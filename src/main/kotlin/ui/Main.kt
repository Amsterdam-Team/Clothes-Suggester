package ui

import di.onStartApplication
import org.koin.java.KoinJavaComponent.getKoin
import ui.controllers.SuggestClothesUIController

fun main() {
    onStartApplication()

    val suggesterUi = getKoin().get<SuggestClothesUIController>()
    suggesterUi.execute()
}