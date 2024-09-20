package org.coffee.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.splash_coffe
import org.coffee.CoffeeBTN
import org.coffee.CoffeeBg
import org.coffee.data.UserDetails
import org.coffee.ui.components.RadioButtonGender
import org.coffee.viewmodel.AuthViewmodel
import org.jetbrains.compose.resources.painterResource


@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit = {},
) {
    val viewModel: AuthViewmodel = koinViewModel<AuthViewmodel>()
  //  val context= LocalContext.current
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }

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
        )
        Text(
            "Register",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 100.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = mobile,
                onValueChange = { mobile = it },
                label = { Text("Mobile") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )

            RadioButtonGender {
                gender=it
               // context.toast(it)

            }

            Button(
                onClick = {
                        viewModel.doRegister(
                            UserDetails(
                                name = name,
                                email = email,
                                mobile = mobile,
                                gender = gender,
                                password = password,
                                isLogin = true
                            )
                        )
                },
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

            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = CoffeeBTN,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()

            ) {
                Text("Login", color = Color.White)
            }

            Spacer(modifier = Modifier.height(130.dp))
        }
    }
}

