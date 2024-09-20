package org.coffee.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.coffee.data.UserDetails
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.coffee.ui.screen.states.LoginUiStates


class AuthViewmodel : ViewModel() {


    private val _uiState = MutableStateFlow<LoginUiStates>(LoginUiStates.Loading)
    val uiStates = _uiState.asStateFlow()

    // val status = mutableStateOf()

    private val _username = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _loginButtonEnabled = MutableStateFlow(false)
    private val _loginError = MutableStateFlow("")

    val username: StateFlow<String> = _username
    val password: StateFlow<String> = _password
    val loginButtonEnabled: StateFlow<Boolean> = _loginButtonEnabled
    val loginError: StateFlow<String> = _loginError

    private val _loginProgress = MutableStateFlow(false)
    val loginProgress: StateFlow<Boolean> = _loginProgress

    private val _isLogged = MutableStateFlow(false)
    val isLogged = _isLogged.asStateFlow()


    init {

        viewModelScope.launch {
          //  _isLogged.value= dataStoreManagement.isLogin()
        }

    }


    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
        checkLoginButtonEnable()
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        checkLoginButtonEnable()
    }

    private fun checkLoginButtonEnable() {
        _loginButtonEnabled.value = _username.value.isNotBlank() && _password.value.isNotBlank()
    }

    fun logOut(){
        viewModelScope.launch {
          //  dataStoreManagement.clearDataStore()
        }
    }

    fun doLogin() {

        viewModelScope.launch {
            try {
                //  repository.login(_username.value, _password.value)
                _loginError.value = ""
                _loginProgress.value = true

               // dataStoreManagement.login(true)

               /* dataStoreManagement.getFromDataStore().collectLatest {
                    Log.d("TAGS", "doLogin email: ${it.email}")
                    Log.d("TAGS", "doLogin Pass: ${it.password}")
                    Log.d("TAGS", "doLogin isLogin: ${it.isLogin}")
                }*/

            } catch (e: Exception) {
                _loginError.value = "Login failed"
            } finally {
                _loginProgress.value = false
            }
        }
    }

    fun doRegister(userDetails: UserDetails) {
      //  Log.d("TAGS", "doRegister: $userDetails")
        viewModelScope.launch {
          //  dataStoreManagement.saveToDataStore(userDetails = userDetails)
        }
    }

    fun doForgotPassword(email: String) {

    }

}

//We have sent an email to karunkumar02525@gmail.com, please click the link included to verify your email address.