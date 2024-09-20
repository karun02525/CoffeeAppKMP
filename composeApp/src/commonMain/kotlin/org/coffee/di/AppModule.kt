package org.coffee.di

import org.coffee.viewmodel.AuthViewmodel
import org.koin.dsl.module

val appModule  = module {
    single {"hii"}
    //single { AuthViewmodel() }
}