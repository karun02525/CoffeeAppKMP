package org.coffee.testUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.ktor.websocket.Frame

@Composable
fun SubscribeBox() {

    var txt by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = txt, onValueChange = {txt=it}, placeholder = { Text("Enter your email") })

        Button(onClick = {
            txt=""
            message="You successfully subscribed"
        }) {
            Frame.Text("SUBSCRIBE")
        }
        Text(
            text = message,
        )
    }
}
