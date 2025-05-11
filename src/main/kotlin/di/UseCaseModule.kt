package di

import logic.usecase.GetCurrentWeatherUseCase
import logic.usecase.SuggestClotheUseCase
import org.koin.dsl.module
import ui.console.ConsoleIO
import ui.console.ConsoleIOImpl
import ui.controllers.GetCurrentWeatherUIController
import ui.controllers.SuggestClothesUIController
import kotlin.math.sin


val useCaseModule = module {

    single { SuggestClothesUIController(get(), get() ) }
    single { SuggestClotheUseCase(get(), get(), get()) }
    single { GetCurrentWeatherUseCase(get(),get()) }
    single { GetCurrentWeatherUIController(get()) }
    single<ConsoleIO> { ConsoleIOImpl() }

}