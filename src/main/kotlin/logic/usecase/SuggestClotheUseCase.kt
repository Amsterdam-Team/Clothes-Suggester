package logic.usecase

import data.remote.response.DayWeather
import kotlinx.datetime.LocalDateTime
import logic.entities.ClothingCategory
import logic.repository.IClothingSuggestionRepository
import logic.exception.ClothesSuggestException.ValidationException.InvalidStartTimeFormat
import logic.exception.ClothesSuggestException.ValidationException.InvalidEndTimeFormat
import logic.exception.ClothesSuggestException.ValidationException.InvalidCityName
import logic.repository.ILocationRepository
import logic.repository.IWeatherRepository
import kotlin.math.round
import logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException
import java.util.*

class SuggestClotheUseCase(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository,
    private val clothingSuggestionRepository: IClothingSuggestionRepository,
) {
    suspend fun suggestClothes(
        startHourInput: String,
        endHourInput: String,
        cityName: String? = null
    ): ClothingCategory {
        val averageWeather = getWeatherAtSpecificPeriod(startHourInput, endHourInput, cityName)
        val avgTemp = averageWeather[TEMPERATURE] ?: throw EmptyDataException
        return clothingSuggestionRepository.getClothingSuggestionsByTemperature(avgTemp.toFloat())
    }

    private suspend fun getWeatherAtSpecificPeriod(
        startHourInput: String,
        endHourInput: String,
        cityName: String?
    ): Map<String, Double?> {

        val userLocation =
            if (cityName == null) locationRepository.getCurrentLocationByIPAddress()
            else {
                if (!isValidCityName(cityName)) throw InvalidCityName
               locationRepository.getLocationByCityName(cityName.lowercase(Locale.getDefault()))
            }

        if (!isValidHour(startHourInput)) throw InvalidStartTimeFormat
        if (!isValidHour(endHourInput)) throw InvalidEndTimeFormat

        val weatherReport = weatherRepository.getWeatherByLocation(userLocation).dayWeather

        return calculateAveragesWeatherData(startHourInput, endHourInput, weatherReport)
    }


    private fun isValidHour(hour: String): Boolean {
        val number = hour.toIntOrNull()
        return hour.isNotBlank() && number != null && number in 0..23
    }


    private fun isValidCityName(cityName: String): Boolean {
        return (cityName.isNotBlank() && cityName.matches(Regex("^[a-zA-Z\\s]+$")))
    }

    private fun calculateAveragesWeatherData(
        startHour: String,
        endHour: String,
        dayWeather: DayWeather?
    ): Map<String, Double?> {

        val timeList = dayWeather?.dataTime ?: return emptyMap()

        val filteredTime = timeList.mapIndexedNotNull { index, timeValue ->
            timeValue?.let {
                val hour = LocalDateTime.parse(it).hour.toString()
                if (hour in startHour..endHour) index else 0
            }
        }

        fun calculateAverageNumber(values: List<Number?>?): Double {
            val filteredData = filteredTime.mapNotNull { values?.getOrNull(it)?.toDouble() }
            return if (filteredData.isNotEmpty()) filteredData.average() else 0.0
        }


        return mapOf(
            TEMPERATURE to round(calculateAverageNumber(dayWeather.temperature)),
            WIND_SPEED to round(calculateAverageNumber(dayWeather.windSpeed)),
            SHOWERS to round(calculateAverageNumber(dayWeather.showers)),
            CLOUD_COVER to round(calculateAverageNumber(dayWeather.cloud))
        )
    }



    private companion object {
        const val TEMPERATURE = "temperature"
        const val WIND_SPEED = "windSpeed"
        const val SHOWERS = "showers"
        const val CLOUD_COVER = "cloudCover"
    }


}