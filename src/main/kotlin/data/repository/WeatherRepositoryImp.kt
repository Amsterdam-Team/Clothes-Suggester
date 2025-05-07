package data.repository

import data.remote.dataSource.IWeatherDataSource
import data.remote.response.WeatherResponse
import logic.entities.Location
import org.example.logic.entities.WeatherReport
import logic.repository.IWeatherRepository

class WeatherRepositoryImp(
    private val weatherAPIDataSource: IWeatherDataSource

) : IWeatherRepository {
    override suspend fun getWeatherReport(): List<WeatherReport> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherByLocation(location: Location): WeatherResponse {
        return weatherAPIDataSource.getWeatherByLocation(
            latitude = location.latitude,
            longitude = location.longitude
        )
    }
}