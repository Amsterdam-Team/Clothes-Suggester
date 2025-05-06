package org.example.logic.repository

import org.example.logic.entities.IpLocationResponse

interface LocationRepository {
    suspend fun getCurrentLocation() : IpLocationResponse
}