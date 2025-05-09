package ui

import di.onStartApplication
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.getKoin
import ui.controllers.GetCurrentWeatherUIController
import ui.controllers.SuggestClothesUIController

fun main() {
    onStartApplication()

    val getCurrentUI = getKoin().get<GetCurrentWeatherUIController>()
    getCurrentUI.execute()

    runBlocking {
        delay(4_000)
    }

    val suggesterUi = getKoin().get<SuggestClothesUIController>()
    suggesterUi.execute()

    runBlocking {
        delay(5_000)
    }
}