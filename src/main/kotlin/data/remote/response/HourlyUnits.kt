package data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    @SerialName("cloud_cover")
    val cloud: String?,
    @SerialName("showers")
    val showers: String?,
    @SerialName("temperature_2m")
    val temperature: String?,
    @SerialName("time")
    val dataTime: String?,
    @SerialName("wind_speed_10m")
    val windSpeed: String?
)