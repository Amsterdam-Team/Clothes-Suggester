package di

import data.remote.dataSource.IWeatherDataSource
import data.remote.dataSource.WeatherDataSourceImp
import data.local.dataSource.ClothesDataSourceImp
import data.local.dataSource.IClothesDataSource
import data.local.dataSource.ILocationDataSource
import data.local.dataSource.LocationDataSourceImp
import org.koin.dsl.module

val dataSourceModule = module {
    single<ILocationDataSource> { LocationDataSourceImp() }
    single<IClothesDataSource> { ClothesDataSourceImp() }
    single<IWeatherDataSource> {
        WeatherDataSourceImp(
            client = get(),
            json = get(),
            baseUrl = get(AppConstants.Qualifiers.WeatherApiBaseUrl)
        )
    }
}