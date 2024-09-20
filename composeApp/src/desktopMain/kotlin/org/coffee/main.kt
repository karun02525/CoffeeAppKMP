package org.coffee

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.coffee.di.KoinInitializer

fun main() {

    KoinInitializer().init()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CoffeeAppKmp",
        ) {
            App()
        }
    }
}