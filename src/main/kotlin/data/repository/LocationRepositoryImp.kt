package data.repository

import logic.entities.Location
import data.local.dataSource.ILocationDataSource
import org.example.logic.entities.IpLocationResponse
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

    override suspend fun getCurrentLocation(): IpLocationResponse {
        TODO("Not yet implemented")
    }
}