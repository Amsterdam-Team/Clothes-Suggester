package logic.repository

import data.remote.response.WeatherResponse
import logic.entities.Location
import org.example.logic.entities.WeatherReport

interface IWeatherRepository {
     suspend fun getWeatherReport() : List<WeatherReport>

     suspend fun getWeatherByLocation(location: Location): WeatherResponse
}