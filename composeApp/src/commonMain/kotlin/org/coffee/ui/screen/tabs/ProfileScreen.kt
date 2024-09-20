package org.coffee.ui.screen.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen1(
                  logout:()->Unit={}
                  ) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
      //  Text( modifier = Modifier.align(Alignment.Center))
        Button(
            onClick = logout
        ) {
            Text("Logout")
        }
    }

}