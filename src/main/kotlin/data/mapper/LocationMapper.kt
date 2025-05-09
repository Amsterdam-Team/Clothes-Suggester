package data.mapper

import data.remote.response.LocationByCityResponse
import data.remote.response.LocationByIPAddressResponse
import logic.entities.Location

fun LocationByCityResponse.toModel():Location{
    return Location(
        longitude = this.lon?:"0.0",
        latitude = this.lat?:"0.0",
        cityName = this.displayName?:""
    )
}

fun LocationByIPAddressResponse.toModel():Location{
    return Location(
        longitude = (this.lon?:0.0).toString(),
        latitude = (this.lat?:0.0).toString(),
        cityName = this.city?:""
    )
}