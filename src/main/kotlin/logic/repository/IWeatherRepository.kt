package logic.repository

import data.remote.response.WeatherResponse
import logic.entities.Location

interface IWeatherRepository {
    suspend fun getWeatherByLocation(location: Location): WeatherResponse
}