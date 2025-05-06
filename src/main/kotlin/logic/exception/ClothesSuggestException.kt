package org.example.logic.exception


sealed class ClothesSuggestException : Exception() {
    sealed class ValidationException : ClothesSuggestException() {
        data object InvalidTimeFormat : ValidationException()
    }

    sealed class DataSourceException : ClothesSuggestException() {
        data object EmptyDataException : DataSourceException()
    }

}