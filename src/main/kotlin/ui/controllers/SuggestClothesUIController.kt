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
        consoleIO.readFromUser()
        consoleIO.println("Please Enter the end hour")
        consoleIO.readFromUser()

        tryToExecute(
            action = {},
            onSuccess = {}
        )
    }
}