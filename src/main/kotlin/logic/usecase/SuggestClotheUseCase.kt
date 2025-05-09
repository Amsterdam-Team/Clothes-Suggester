package logic.usecase

import data.remote.response.DayWeather
import kotlinx.datetime.LocalDateTime
import logic.entities.ClothingCategory
import logic.exception.ClothesSuggestException
import logic.repository.IClothingSuggestionRepository
import logic.entities.Location
import logic.exception.ClothesSuggestException.ValidationException.InvalidCityName
import logic.repository.ILocationRepository
import logic.repository.IWeatherRepository
import kotlin.math.round
import logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException

class SuggestClotheUseCase(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository,
    private val validateUserInput: ValidateUserInput,
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

        val userLocation = if (cityName == null) getLocationByIpAddress() else getLocationByCityName(cityName)

        validateUserInput.isValidInput(startHourInput)
        validateUserInput.isValidInput(endHourInput)

        val weatherReport = weatherRepository.getWeatherByLocation(userLocation).dayWeather

        return calculateAveragesWeatherData(startHourInput, endHourInput, weatherReport)
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


    private suspend fun getLocationByIpAddress() = locationRepository.getCurrentLocationByIPAddress()

    private suspend fun getLocationByCityName(cityName: String):Location {
        if (!validateUserInput.isValidCityName(cityName))
            throw InvalidCityName
        return locationRepository.getLocationByCityName(cityName)


    }


}