package logic.repository

import logic.entities.Location

interface ILocationRepository {
    fun setUserLocation(location: Location)
    fun getUserLocation(): Location
}