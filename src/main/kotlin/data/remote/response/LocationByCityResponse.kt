package data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationByCityResponse(
    @SerialName("boundingbox")
    val boundingBox: List<String?>?,
    @SerialName("class")
    val classX: String?,
    @SerialName("display_name")
    val displayName: String?,
    @SerialName("importance")
    val importance: Double?,
    @SerialName("lat")
    val latitude: String?,
    @SerialName("licence")
    val licence: String?,
    @SerialName("lon")
    val longitude: String?,
    @SerialName("osm_id")
    val osmId: String?,
    @SerialName("osm_type")
    val osmType: String?,
    @SerialName("place_id")
    val placeId: String?,
    @SerialName("type")
    val type: String?,

    )