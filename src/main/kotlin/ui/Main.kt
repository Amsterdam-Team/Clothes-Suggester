package ui

import di.onStartApplication
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.getKoin
import ui.controllers.SuggestClothesUIController

fun main() {
    onStartApplication()

    val suggesterUi = getKoin().get<SuggestClothesUIController>()
    suggesterUi.execute()

    runBlocking {
        delay(7_000)
    }
}