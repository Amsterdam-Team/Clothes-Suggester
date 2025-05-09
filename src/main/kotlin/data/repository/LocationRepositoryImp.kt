package data.repository

import data.local.dataSource.ILocationDataSource
import logic.entities.Location
import logic.repository.ILocationRepository

class LocationRepositoryImp(
    private val locationDataSource: ILocationDataSource,
) : ILocationRepository {
    override fun setUserLocation(location: Location) {
        locationDataSource.setUserLocation(location)
    }

    override fun getUserLocation(): Location {
        return locationDataSource.getUserLocation()
    }
}