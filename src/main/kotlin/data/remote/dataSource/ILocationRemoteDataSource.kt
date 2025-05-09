package data.remote.dataSource

import data.remote.response.LocationByCityResponse
import data.remote.response.LocationByIPAddressResponse

interface ILocationRemoteDataSource {

    suspend fun getCurrentLocationByIPAddress():LocationByIPAddressResponse
    suspend fun getLocationByCityName(cityName:String):List<LocationByCityResponse>

}