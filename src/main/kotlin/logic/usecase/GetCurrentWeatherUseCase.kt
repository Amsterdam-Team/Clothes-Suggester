package logic.usecase

import data.remote.response.WeatherResponse
import logic.repository.ILocationRepository
import logic.repository.IWeatherRepository

class GetCurrentWeatherUseCase(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository
) {
    suspend fun execute(): WeatherResponse {
        val userLocation = locationRepository.getCurrentLocationByIPAddress()
        return weatherRepository.getWeatherByLocation(userLocation)
    }
}