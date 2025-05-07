package di

import org.koin.core.context.startKoin

fun onStartApplication() {
    startKoin{
        modules(networkModule, dataSourceModule, repositoryModule, useCaseModule)
    }
}