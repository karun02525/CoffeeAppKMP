package org.coffee.ui.screen.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FilterScreen(modifier: Modifier = Modifier) {
    Box {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            Text("Filter Screen",
                modifier = Modifier
                    .align(Alignment.Center))

        }
    }
}