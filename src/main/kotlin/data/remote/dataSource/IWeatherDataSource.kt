package data.remote.dataSource

import data.remote.response.WeatherResponse

interface IWeatherDataSource {
    suspend fun getWeatherByLocation(latitude: Double, longitude: Double): WeatherResponse
}