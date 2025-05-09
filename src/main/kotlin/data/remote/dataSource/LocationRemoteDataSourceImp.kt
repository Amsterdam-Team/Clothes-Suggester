package data.remote.dataSource

import data.remote.response.LocationByCityResponse
import data.remote.response.LocationByIPAddressResponse
import data.remote.utils.getClassByResponse
import data.remote.utils.safeApiCall
import di.AppConstants.API_KEY
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class LocationRemoteDataSourceImp(
    private val client: HttpClient,
    private val json: Json,
    private val ipBaseUrl: String,
    private val cityBaseUrl: String,

): ILocationRemoteDataSource {

    override suspend fun getCurrentLocationByIPAddress(): LocationByIPAddressResponse {
        val response =
            safeApiCall {
                client.get(ipBaseUrl)
            }

        return getClassByResponse<LocationByIPAddressResponse>(response = response, json = json)
    }

    override suspend fun getLocationByCityName(cityName: String): List<LocationByCityResponse>{
        val response =
            safeApiCall {
                client.get("$cityBaseUrl?key=${API_KEY}&q=${cityName}&format=json")
            }
        return getClassByResponse<List<LocationByCityResponse>>(response = response, json = json)
    }

}