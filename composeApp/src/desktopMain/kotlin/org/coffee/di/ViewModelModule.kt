package org.coffee.di

import org.koin.dsl.module
import org.coffee.viewmodel.AuthViewmodel
import org.koin.core.module.dsl.singleOf

actual val viewModelModule = module {
       singleOf(::AuthViewmodel)
}