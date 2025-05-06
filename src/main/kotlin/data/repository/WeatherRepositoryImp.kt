package main.kotlin.data.repository

import org.example.logic.entities.WeatherReport
import org.example.logic.repository.WeatherRepository

class WeatherRepositoryImp : WeatherRepository{
    override suspend fun getWeatherReport(): List<WeatherReport> {
        TODO("Not yet implemented")
    }
}