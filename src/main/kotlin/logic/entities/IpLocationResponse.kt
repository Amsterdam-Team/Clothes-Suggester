package org.example.logic.entities
import kotlinx.serialization.Serializable

@Serializable
data class IpLocationResponse(
    val country: String,
    val regionName: String,
    val city: String,
    val lat: Double,
    val lon: Double
)
