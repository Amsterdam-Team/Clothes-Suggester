package ui.controllers

import logic.usecase.SuggestClotheUseCase
import ui.baseController.BaseUIController
import ui.console.ConsoleIO
import ui.utils.tryToExecute

class SuggestClothesUIController(
    private val suggestClotheUseCase: SuggestClotheUseCase,
    private val consoleIO: ConsoleIO
) : BaseUIController {
    override fun execute() {
        consoleIO.println("Please Enter the start hour")
        val startHour = consoleIO.readFromUser()
        consoleIO.println("Please Enter the end hour")
        val endHour = consoleIO.readFromUser()
        consoleIO.println("Enter city name or leave empty to use your current location:")
        val cityName = consoleIO.readFromUser().takeIf { it.isNotBlank() }
        tryToExecute(
            action = {
                suggestClotheUseCase.suggestClothes(startHour,endHour,cityName)
            },
            onSuccess = {
                suggestion ->
                consoleIO.println("Suggested clothing items for this time range are:")
                suggestion.suggestion.forEach { item ->
                    consoleIO.println("- $item")
                }
            },
            onError = { throwable ->
                consoleIO.println("An error occurred while fetching suggestions: ${throwable.message}")
            }
        )
    }
}