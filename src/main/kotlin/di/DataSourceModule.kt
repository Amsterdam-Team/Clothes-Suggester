package di

import data.remote.dataSource.IWeatherDataSource
import data.remote.dataSource.WeatherDataSourceImp
import data.local.dataSource.ClothesDataSourceImp
import data.local.dataSource.IClothesDataSource
import data.remote.dataSource.ILocationRemoteDataSource
import data.remote.dataSource.LocationRemoteDataSourceImp
import org.koin.dsl.module

val dataSourceModule = module {
    single<IClothesDataSource> { ClothesDataSourceImp() }
    single<IWeatherDataSource> {
        WeatherDataSourceImp(
            client = get(),
            json = get(),
            baseUrl = get(AppConstants.Qualifiers.WeatherApiBaseUrl)
        )
    }
    single<ILocationRemoteDataSource> {
        LocationRemoteDataSourceImp(
            client = get(),
            json = get(),
            ipBaseUrl = get(AppConstants.Qualifiers.LocationByIpApiBaseUrl),
            cityBaseUrl = get(AppConstants.Qualifiers.LocationByCityApiBaseUrl),

        )
    }
}