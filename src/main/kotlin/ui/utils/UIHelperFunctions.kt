package ui.utils

import org.example.logic.exception.ClothesSuggestException
import org.example.logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException
import org.example.logic.exception.ClothesSuggestException.ValidationException.InvalidTimeFormat

fun String.printAsASuccessState() {
    val green = "\u001B[32m"
    val reset = "\u001B[0m"
    println("$green$this$reset")
}

fun String.printAsAFailState() {
    val red = "\u001b[31m"
    val reset = "\u001B[0m"
    println("$red$this$reset")
}

fun getErrorMessageByException(exception: Exception): String {

    return when (exception) {
        is InvalidTimeFormat -> "You need admin privileges to perform this action."

        is EmptyDataException -> "You must enter some data, this field cannot be empty"

        is ClothesSuggestException -> "Something went wrong with your request. Please try again."

        else -> "An unexpected error occurred. Please try again later."
    }
}