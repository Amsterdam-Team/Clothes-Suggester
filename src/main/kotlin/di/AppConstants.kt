package di

import org.koin.core.qualifier.named

object AppConstants {
    const val WEATHER_API_BASE_URL = "https://api.open-meteo.com/v1/forecast"

    object Qualifiers {
        val WeatherApiBaseUrl = named("WeatherApiBaseUrl")
    }
}