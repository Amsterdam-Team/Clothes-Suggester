package ui.utils

import logic.exception.ClothesSuggestException
import logic.exception.ClothesSuggestException.DataSourceException.EmptyDataException
import logic.exception.ClothesSuggestException.NetworkException.*
import logic.exception.ClothesSuggestException.ValidationException.InvalidTimeFormat

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

fun getErrorMessageByThrowable(throwable: Throwable): String {

    return when (throwable) {
        is InvalidTimeFormat -> "Please enter time in hours from 0 to 23 only"

        is EmptyDataException -> "You must enter some data, this field cannot be empty"

        is ClothesSuggestException -> "Something went wrong with your request. Please try again."

        is NoInternetException -> "No internet connection. Please check your network and try again."

        is TimeoutException -> "The request timed out. Please try again in a few moments."

        is ServerException -> "Server error occurred. We're working on it, please try again later."

        is UnknownNetworkException -> "A network error occurred. Please try again."

        else -> "An unexpected error occurred. Please try again later."
    }
}