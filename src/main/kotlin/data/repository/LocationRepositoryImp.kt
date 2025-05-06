package org.example.data.repository

import org.example.logic.entities.IpLocationResponse
import org.example.logic.repository.LocationRepository

class LocationRepositoryImp : LocationRepository {
    override suspend fun getCurrentLocation(): IpLocationResponse {
        TODO("Not yet implemented")
    }
}