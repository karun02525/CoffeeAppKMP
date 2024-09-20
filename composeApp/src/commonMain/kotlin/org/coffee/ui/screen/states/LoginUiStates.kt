package org.coffee.ui.screen.states

sealed interface LoginUiStates {
    data object Loading : LoginUiStates
    data class Error(val error:String):LoginUiStates
    data object Progress : LoginUiStates
}