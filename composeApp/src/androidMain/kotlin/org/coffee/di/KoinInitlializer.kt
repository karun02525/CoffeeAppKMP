package org.coffee.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val content:Context
) {

    actual fun init(){
           startKoin {
               androidContext(content)
               androidLogger()
               modules(appModule, viewModelModule)
           }
    }
}