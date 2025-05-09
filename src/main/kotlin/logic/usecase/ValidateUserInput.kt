package logic.usecase

import logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException
import logic.exception.ClothesSuggestException.ValidationException.InvalidTimeFormat

class ValidateUserInput {
    fun isValidInput(input: String): Boolean {
        if (input.isBlank()) throw EmptyDataException
        val number = input.toIntOrNull() ?: throw InvalidTimeFormat
        if (number !in 0..23) throw InvalidTimeFormat
        return true
    }

    fun isValidCityName(cityName:String) =
        (cityName.isNotBlank() && cityName.matches(Regex("^[a-zA-Z\\s]+$")))

}