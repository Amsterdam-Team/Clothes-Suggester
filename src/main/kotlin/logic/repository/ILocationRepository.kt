package logic.repository
import logic.entities.Location


interface ILocationRepository {

    suspend fun getCurrentLocationByIPAddress(): Location
    suspend fun getLocationByCityName(cityName:String): Location
}