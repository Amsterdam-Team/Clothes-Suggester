package di

import org.koin.core.qualifier.named

object AppConstants {
    const val WEATHER_API_BASE_URL = "https://api.open-meteo.com/v1/forecast"
    const val LOCATION_BY_IP_API_BASE_URL = "http://ip-api.com/json"
    const val LOCATION_BY_CITY_API_BASE_URL = "https://us1.locationiq.com/v1/search.php"
    const val API_KEY = "pk.0aa96644f3d46d96744db9b5bc07822f"


    object Qualifiers {
        val WeatherApiBaseUrl = named("WeatherApiBaseUrl")
        val LocationByIpApiBaseUrl = named("LocationByIpApiBaseUrl")
        val LocationByCityApiBaseUrl = named("LocationByCityApiBaseUrl")

    }
}