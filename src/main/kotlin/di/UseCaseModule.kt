package di

import logic.usecase.SuggestClotheUseCase
import logic.usecase.ValidateUserInput
import org.koin.dsl.module
import ui.console.ConsoleIO
import ui.console.ConsoleIOImpl
import ui.controllers.SuggestClothesUIController


val useCaseModule = module {

    single { SuggestClothesUIController(get(), get() ) }
    single { SuggestClotheUseCase(get(), get(), get(), get() ) }
    single { ValidateUserInput() }
    single<ConsoleIO> { ConsoleIOImpl() }

}