package data.local.dataSource

import logic.entities.Location

class LocationDataSourceImp: ILocationDataSource {
    private var userLocation = Location(latitude = 33.34f, longitude = 44.4f)

    override fun setUserLocation(location: Location) {
        userLocation = Location(latitude = location.latitude, longitude = location.longitude)
    }

    override fun getUserLocation(): Location = userLocation
}