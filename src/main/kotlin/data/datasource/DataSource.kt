package data.datasource

import org.example.logic.repository.WeatherRepository

interface DataSource {
    suspend fun getWeather() : WeatherRepository
}