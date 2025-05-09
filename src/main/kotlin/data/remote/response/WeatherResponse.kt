package data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("elevation")
    val elevation: Double?,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerialName("hourly")
    val dayWeather: DayWeather?,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)