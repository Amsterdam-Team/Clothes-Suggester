package di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

fun onStartApplication() {
    startKoin{
        modules(networkModule, dataSourceModule, repositoryModule, useCaseModule, coroutineModule)
    }
}

fun onDestroyApplication(){
    runBlocking { delay(7_000) }

    val appCoroutineScope = getKoin().get<CoroutineScope>()
    appCoroutineScope.cancel()
}