package ui.controllers

import data.remote.response.WeatherResponse
import logic.usecase.GetCurrentWeatherUseCase
import ui.baseController.BaseUIController
import ui.controllers.SuggestClothesUIController.Companion.WELCOME_MESSAGE
import ui.utils.DisplayUtils.printBoxedMessage
import ui.utils.tryToExecute
import java.time.LocalDateTime

class GetCurrentWeatherUIController(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : BaseUIController {

    override fun execute() {
        printBoxedMessage(WELCOME_MESSAGE)

        tryToExecute(
            action = { getCurrentWeatherUseCase.execute() },
            onSuccess = { generateFriendlyWeatherReport(it) }
        )
    }

    private fun generateFriendlyWeatherReport(weatherResponse: WeatherResponse) {
        val dayWeather = weatherResponse.dayWeather
        if (dayWeather == null || dayWeather.temperature.isNullOrEmpty() || dayWeather.dataTime.isNullOrEmpty()) {
            println("Sorry, I couldn't fetch the latest weather data.")
            return
        }

        val index = dayWeather.temperature.lastIndex
        val time = "${LocalDateTime.now().hour}:${LocalDateTime.now().minute}"
        val temp = dayWeather.temperature.getOrNull(index)
        val wind = dayWeather.windSpeed?.getOrNull(index)
        val cloud = dayWeather.cloud?.getOrNull(index)
        val showers = dayWeather.showers?.getOrNull(index)

        val tempMessage = when {
            temp == null -> "Temperature info is missing."
            temp < 0 -> "Brrr! It's freezing outside at $temp°C. ❄️ Make sure to bundle up!"
            temp in 0.0..10.0 -> "It's quite chilly at $temp°C. 🧥 You might want a jacket."
            temp in 10.0..20.0 -> "Cool and pleasant at $temp°C. 🌤 A light jacket should do."
            temp in 20.0..30.0 -> "Nice and warm at $temp°C. 😎 Perfect weather to be outside!"
            temp > 30 -> "It's hot out there at $temp°C. ☀️ Stay hydrated and wear sunscreen!"
            else -> "Current temperature is $temp°C."
        }

        val cloudMessage = cloud?.let {
            when {
                it < 20 -> "The sky is mostly clear. ☀️"
                it in 20..50 -> "There are a few clouds out. 🌤"
                it in 51..80 -> "It's fairly cloudy. 🌥"
                else -> "Overcast skies today. ☁️"
            }
        } ?: "Cloud information is unavailable."

        val showerMessage = when {
            showers == null -> "Rain data is unavailable."
            showers > 5 -> "Heavy showers expected. 🌧 Don't forget your umbrella!"
            showers in 1.0..5.0 -> "Light rain may occur. 🌦"
            else -> "No rain expected. 😊"
        }

        val windMessage = wind?.let {
            when {
                it < 5 -> "It's quite calm today. 🍃"
                it in 5.0..15.0 -> "A gentle breeze is blowing. 🌬"
                else -> "It's windy out there! 💨 Hold on to your hat!"
            }
        } ?: "Wind speed data is not available."

        val locationInfo =
            "📍 Location: ${weatherResponse.latitude}, ${weatherResponse.longitude} (${weatherResponse.timezone ?: "unknown timezone"})"
        val timeInfo = "🕒 Time: $time"

        println()
        println("""
            🌦 Here's your current weather update:
            $tempMessage
            $cloudMessage
            $showerMessage
            $windMessage
            $locationInfo
            $timeInfo
        """.trimIndent() )
    }

}