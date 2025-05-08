package data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    @SerialName("interval")
    val interval: Int? = null,
    @SerialName("is_day")
    val isDay: Int? = null,
    @SerialName("temperature")
    val temperature: Float? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weathercode")
    val weatherCode: Int? = null,
    @SerialName("winddirection")
    val windDirection: Int? = null,
    @SerialName("windspeed")
    val windSpeed: Float? = null
)