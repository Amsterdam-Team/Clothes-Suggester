package ui

import di.onDestroyApplication
import di.onStartApplication
import org.koin.java.KoinJavaComponent.getKoin
import ui.controllers.GetCurrentWeatherUIController
import ui.controllers.SuggestClothesUIController

fun main() {
    onStartApplication()

    val getCurrentUI = getKoin().get<GetCurrentWeatherUIController>()
    getCurrentUI.execute()


    val suggesterUi = getKoin().get<SuggestClothesUIController>()
    suggesterUi.execute()

    onDestroyApplication()

}