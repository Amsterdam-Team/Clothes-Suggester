package data.remote.dataSource

import data.remote.response.WeatherResponse

interface IWeatherDataSource {
    suspend fun getWeatherByLocation(latitude: Float, longitude: Float): WeatherResponse
}