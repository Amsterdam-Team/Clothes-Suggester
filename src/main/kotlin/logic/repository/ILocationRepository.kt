package logic.repository

import data.remote.response.LocationByCityResponse
import data.remote.response.LocationByIPAddressResponse
import logic.entities.Location
import org.example.logic.entities.IpLocationResponse

interface ILocationRepository {

    suspend fun getCurrentLocationByIPAddress(): Location
    suspend fun getLocationByCityName(cityName:String): Location
}