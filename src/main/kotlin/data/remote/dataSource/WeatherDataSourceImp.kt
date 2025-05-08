package data.remote.dataSource

import data.remote.response.WeatherResponse
import data.remote.utils.getClassByResponse
import data.remote.utils.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class WeatherDataSourceImp(
    private val client: HttpClient,
    private val json: Json,
    private val baseUrl: String
) : IWeatherDataSource {

    override suspend fun getWeatherByLocation(latitude: Float, longitude: Float): WeatherResponse {
        val response =
            safeApiCall {
                client.get("$baseUrl?latitude=$latitude&longitude=$longitude&current_weather=true")
            }

        return getClassByResponse<WeatherResponse>(response = response, json = json)
    }


}