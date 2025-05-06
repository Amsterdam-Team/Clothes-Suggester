package org.example.logic.repository

import org.example.logic.entities.WeatherReport

interface WeatherRepository {
     suspend fun getWeatherReport() : List<WeatherReport>
}