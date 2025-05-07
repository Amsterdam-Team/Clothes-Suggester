package data.remote.dataSource

import data.remote.response.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class WeatherDataSourceImp(
    private val client: HttpClient,
    private val json: Json,
    private val baseUrl: String
) : IWeatherDataSource {

    override suspend fun getWeatherByLocation(latitude: Float, longitude: Float): WeatherResponse {
        val response =
            client.get("$baseUrl?latitude=$latitude&longitude=$longitude&current_weather=true")

        return getClassByResponse<WeatherResponse>(response)
    }

    private suspend inline fun <reified T> getClassByResponse(response: HttpResponse): T {
        return json.decodeFromString<T>(response.bodyAsText())
    }

}