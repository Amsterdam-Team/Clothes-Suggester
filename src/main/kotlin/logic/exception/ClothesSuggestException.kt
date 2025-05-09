package logic.exception


sealed class ClothesSuggestException : Exception() {
    sealed class ValidationException : ClothesSuggestException() {
        data object InvalidTimeFormat : ValidationException()
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