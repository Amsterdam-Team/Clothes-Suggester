package data.local.dataSource

import logic.entities.Location

interface ILocationDataSource {
    fun setUserLocation(location: Location)
    fun getUserLocation(): Location
}