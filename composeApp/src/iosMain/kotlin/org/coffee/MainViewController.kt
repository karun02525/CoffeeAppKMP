package org.coffee

import androidx.compose.ui.window.ComposeUIViewController
import org.coffee.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) { App() }