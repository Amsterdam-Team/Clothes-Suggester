package data.repository

import data.remote.dataSource.IWeatherDataSource
import data.remote.response.WeatherResponse
import logic.entities.Location
import logic.repository.IWeatherRepository

class WeatherRepositoryImp(
    private val weatherAPIDataSource: IWeatherDataSource

) : IWeatherRepository {

    override suspend fun getWeatherByLocation(location: Location): WeatherResponse {
        return weatherAPIDataSource.getWeatherByLocation(
            latitude = location.latitude,
            longitude = location.longitude
        )
    }
}