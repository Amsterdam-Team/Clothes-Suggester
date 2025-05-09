package logic.usecase

import data.remote.response.DayWeather
import logic.entities.Location
import logic.repository.ILocationRepository
import logic.repository.IWeatherRepository

class SuggestClotheUseCase(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository
) {


    private suspend fun getLocationByIpAddress() = locationRepository.getCurrentLocationByIPAddress()
    private suspend fun getLocationByCityName(cityName:String) = locationRepository.getLocationByCityName(cityName)

}