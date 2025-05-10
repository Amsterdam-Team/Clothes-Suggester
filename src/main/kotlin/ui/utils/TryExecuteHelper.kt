package ui.utils

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.java.KoinJavaComponent.getKoin
import ui.utils.DisplayUtils.printError

fun <T> tryToExecute(
    action: suspend () -> T,
    onSuccess: (result: T) -> Unit,
    onError: (throwable: Throwable) -> Unit = {},
    coroutineScope: CoroutineScope = getKoin().get(),
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    val isLoading = MutableStateFlow(true)
    val clothesSuggesterErrorHandler = CoroutineExceptionHandler { _, throwable ->
        printError(getErrorMessageByThrowable(throwable))
        onError(throwable)
        isLoading.value = false
    }

    coroutineScope.launch(dispatcher + clothesSuggesterErrorHandler) {
        launch { loading(isLoading) }

        val actionJop = async { action() }
        onSuccess(actionJop.await())

        isLoading.value = false
    }
}

suspend fun loading(isLoading: StateFlow<Boolean>) {
    var dotCount = 0
    while (isLoading.value) {
        val dots = ".".repeat(dotCount % 4)
        print("\r$dots   ")
        delay(500)
        dotCount++
    }
}



