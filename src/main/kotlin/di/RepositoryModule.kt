package di

import data.repository.WeatherRepositoryImp
import data.repository.ClothingSuggestionRepositoryImp
import data.repository.LocationRepositoryImp
import logic.repository.IClothingSuggestionRepository
import logic.repository.ILocationRepository
import logic.repository.IWeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IWeatherRepository> { WeatherRepositoryImp(get()) }
    single<ILocationRepository> { LocationRepositoryImp(get()) }
    single<IClothingSuggestionRepository> { ClothingSuggestionRepositoryImp(get()) }
}