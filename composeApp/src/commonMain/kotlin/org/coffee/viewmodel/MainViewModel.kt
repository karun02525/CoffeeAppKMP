package org.coffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val hell:String
) : ViewModel(){

    private val _timer = MutableStateFlow(0)
    val timer = _timer.asStateFlow()


    init {
        startTimer()
        println("***********************")
        println(hell)
        println("***********************")
    }

    private fun startTimer(){
        viewModelScope.launch {
            while (true){
                delay(1000)
                _timer.value++
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
    }
}