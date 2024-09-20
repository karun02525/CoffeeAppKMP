package org.coffee.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.ic_email
import coffeeappkmp.composeapp.generated.resources.ic_lock
import coffeeappkmp.composeapp.generated.resources.ic_password_eye
import coffeeappkmp.composeapp.generated.resources.ic_visibility_off
import coffeeappkmp.composeapp.generated.resources.splash_coffe
import org.coffee.CoffeeBTN
import org.coffee.CoffeeBg
import org.coffee.ui.screen.states.LoginUiStates
import org.coffee.viewmodel.AuthViewmodel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.currentKoinScope


@Composable
fun LoginContent(
    onClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onForgotClick: () -> Unit = {}
) {
    val viewModel:AuthViewmodel = koinViewModel<AuthViewmodel>()

   // val (email, setEmail) = remember { mutableStateOf("") }
 //   val (password, setPassword) = remember { mutableStateOf("") }

    val uiStates by viewModel.uiStates.collectAsState()

    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginButtonEnabled by viewModel.loginButtonEnabled.collectAsState()
    val loginError by viewModel.loginError.collectAsState()
    val loginProgress by viewModel.loginProgress.collectAsState()


    var obscureText by remember { mutableStateOf(false) }



    //Handle UI State
    when(uiStates){
        is LoginUiStates.Loading->{}
        is LoginUiStates.Error->{}
        is LoginUiStates.Progress->{

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CoffeeBg)
    ) {



        Image(
            painter = painterResource(Res.drawable.splash_coffe),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            alpha=0.2f,
            modifier = Modifier
                .fillMaxSize()
            // .aspectRatio(5 / 5f)
        )

        Text(
            "Welcome back ",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 100.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                value = username,
                onValueChange = { viewModel.onUsernameChange(it) },
                shape = MaterialTheme.shapes.small,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    disabledTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White

                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = {
                    Icon(painter = painterResource(Res.drawable.ic_email), "email")
                },
                label = { Text("Email address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChange(it) },
                shape = MaterialTheme.shapes.small,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    disabledTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedTrailingIconColor = Color.White,
                    focusedTrailingIconColor = Color.White,

                ),
                leadingIcon = {
                    Icon(painter = painterResource(Res.drawable.ic_lock), "password")
                },
                trailingIcon = {
                    val drawableIcon = if (obscureText) {
                        Res.drawable.ic_password_eye
                    } else {
                        Res.drawable.ic_visibility_off
                    }
                    IconButton(
                        onClick = { obscureText = !obscureText }
                    ) {
                        Icon(painter = painterResource(drawableIcon), "show")
                    }
                },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "Forgot password",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .clickable { onForgotClick() }
                    .fillMaxWidth(),
                textDecoration = TextDecoration.Underline,
                color = Color.White
            )

            if (loginProgress) {
                CircularProgressIndicator()
            }

            Spacer(modifier = Modifier.height(30.dp))
            if (loginError.isNotBlank()) {
                Text(loginError, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                enabled = loginButtonEnabled,
                onClick = {
                    viewModel.doLogin()
                    onClick()
                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = CoffeeBTN,
                    contentColor = Color.White,
                    disabledContainerColor =  Color.White.copy(0.2f),
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()

            ) {
                Text("Login", color = Color.White)
            }

            Button(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = CoffeeBTN,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()

            ) {
                Text("Register", color = Color.White)
            }

            Spacer(modifier = Modifier.height(130.dp))
        }
    }
}

@Composable
inline fun <reified T: ViewModel>koinViewModel(): T{
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}