package org.example.logic.entities

data class WeatherReport (
    val dataTime : kotlinx.datetime.LocalDateTime,
    val temperature : Double,
    val windSpeed : Double,
    val showers : Double,
    val cloud : Int
)