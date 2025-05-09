package data.remote.response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayWeather(
    @SerialName("cloud_cover")
    val cloud: List<Int?>?,
    @SerialName("showers")
    val showers: List<Double?>?,
    @SerialName("temperature_2m")
    val temperature: List<Double?>?,
    @SerialName("time")
    val dataTime: List<String?>?,
    @SerialName("wind_speed_10m")
    val windSpeed: List<Double?>?
)