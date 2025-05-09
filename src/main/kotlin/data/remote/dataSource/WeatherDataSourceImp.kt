package data.remote.dataSource

import data.remote.response.WeatherResponse
import data.remote.utils.getClassByResponse
import data.remote.utils.safeApiCall
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class WeatherDataSourceImp(
    private val client: HttpClient, private val json: Json, private val baseUrl: String
) : IWeatherDataSource {

    override suspend fun getWeatherByLocation(latitude: Double, longitude: Double): WeatherResponse {
        val response = safeApiCall {
            client.get(
                "$baseUrl?latitude=$latitude&longitude=$longitude&hourly=temperature_2m," + "wind_speed_10m,showers,cloud_cover&forecast_days=1"
            )
        }

        return getClassByResponse<WeatherResponse>(response = response, json = json)
    }


}