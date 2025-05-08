package logic.repository

import logic.entities.Location
import org.example.logic.entities.IpLocationResponse

interface ILocationRepository {
    fun setUserLocation(location: Location)
    fun getUserLocation(): Location

    suspend fun getCurrentLocation() : IpLocationResponse
}