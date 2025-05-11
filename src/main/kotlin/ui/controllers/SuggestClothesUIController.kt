package ui.controllers

import logic.entities.ClothingCategory
import logic.usecase.SuggestClotheUseCase
import ui.baseController.BaseUIController
import ui.console.ConsoleIO
import ui.utils.DisplayUtils.printDashedLine
import ui.utils.DisplayUtils.printSubTitle
import ui.utils.DisplayUtils.printSuccess
import ui.utils.DisplayUtils.promptInput
import ui.utils.tryToExecute

class SuggestClothesUIController(
    private val suggestClotheUseCase: SuggestClotheUseCase,
    private val consoleIO: ConsoleIO
) : BaseUIController {
    override fun execute() {
        val userChoice = promptUserInput(LOCATION_MESSAGE)

        var cityName:String? = null
        if(userChoice.lowercase() == "y") cityName = promptUserInput(COUNTRY_NAME_MESSAGE)

        val startHour = promptUserInput(START_HOUR_MESSAGE)
        val endHour = promptUserInput(END_HOUR_MESSAGE)

        tryToExecute(
            action = { suggestClotheUseCase.suggestClothes(startHour,endHour,cityName) },
            onSuccess = ::onGetSuggestClotheSuccess
        )
    }

    private fun onGetSuggestClotheSuccess(clothingCategory : ClothingCategory){
        printSubTitle(SUGGEST_MESSAGE)
        clothingCategory.suggestion.forEach { item ->
            printSuccess("- $item")
        }
    }

    private fun promptUserInput(message: String): String {
        printDashedLine()
        promptInput(message)
        return consoleIO.readFromUser()
    }
    
    companion object{
        const val WELCOME_MESSAGE = "Welcome to Suggester App"
        const val LOCATION_MESSAGE = "Your Location is Determined Using Your Device Ip By Default\n IF You Need Specific Country Name To Determine Your Location Enter (Y) "
        const val COUNTRY_NAME_MESSAGE = "Great Now Enter Name Of Country :"
        const val START_HOUR_MESSAGE = "Now We Need You Enter Start Hour And End Hour To Suggest Clothes Based On it\nEnter The Start Hour :"
        const val END_HOUR_MESSAGE = "Enter The End Hour :"
        const val SUGGEST_MESSAGE = "\nSuggested Clothing Items For This Time Range Are:"
    }
}