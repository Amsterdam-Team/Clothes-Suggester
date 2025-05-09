package ui.utils

import kotlinx.coroutines.*

fun <T> tryToExecute(
    action: suspend () -> T,
    onSuccess: (result: T) -> Unit,
    onError: (throwable: Throwable) -> Unit = {},
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    val clothesSuggesterErrorHandler = CoroutineExceptionHandler { _, throwable ->
        getErrorMessageByThrowable(throwable).printAsAFailState()
        onError(throwable)
    }

    GlobalScope.launch(dispatcher + clothesSuggesterErrorHandler) {
        val actionJop = async { action() }
        val loadingJob = launch { loading(true) }

        actionJop.join()
        onSuccess(actionJop.await())

        loadingJob.cancel()


    }
}

suspend fun loading(isLoading: Boolean) {
    var dotCount = 0
    while (isLoading) {
        val dots = ".".repeat(dotCount % 4)
        print("\rLoading$dots   ")
        delay(500)
        dotCount++
    }
}



