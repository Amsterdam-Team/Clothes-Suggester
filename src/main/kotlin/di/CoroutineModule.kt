package di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutineModule = module {
    single<CoroutineScope> { CoroutineScope(Dispatchers.Default) }
}