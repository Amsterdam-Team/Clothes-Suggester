package data.repository

import logic.entities.Location
import data.mapper.toModel
import data.remote.dataSource.ILocationRemoteDataSource
import logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException
import logic.repository.ILocationRepository

class LocationRepositoryImp(
    private val locationRemoteDataSource: ILocationRemoteDataSource
) : ILocationRepository {


    override suspend fun getCurrentLocationByIPAddress(): Location {
        return locationRemoteDataSource.getCurrentLocationByIPAddress().toModel()
    }

    override suspend fun getLocationByCityName(cityName: String): Location {
        return locationRemoteDataSource.getLocationByCityName(cityName).ifEmpty {
            throw EmptyDataException
        }[0].toModel()
    }


}