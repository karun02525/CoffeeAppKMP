package org.coffee.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.coffee.viewmodel.AuthViewmodel

actual val viewModelModule = module {
       viewModelOf(::AuthViewmodel)
}