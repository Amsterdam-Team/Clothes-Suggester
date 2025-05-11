package logic.exception


sealed class ClothesSuggestException : Exception() {
    sealed class ValidationException : ClothesSuggestException() {
        data object InvalidStartTimeFormat : ValidationException()
        data object InvalidEndTimeFormat : ValidationException()
        data object InvalidCityName :ValidationException()
    }

    sealed class DataSourceException : ClothesSuggestException() {
        data object EmptyDataException : DataSourceException()
    }

    sealed class NetworkException : ClothesSuggestException() {
        data object NoInternetException : NetworkException()
        data object TimeoutException : NetworkException()
        data object ServerException : NetworkException()
        data object UnknownNetworkException : NetworkException()
    }
}