package org.coffee.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.profile
import org.coffee.CoffeeBgSec
import org.coffee.White
import org.jetbrains.compose.resources.painterResource


@Composable
fun ProfileScreen() {
    Column(
        modifier=Modifier.fillMaxSize()
            .background(CoffeeBgSec)
    ) {

        Text("My profile",
            fontSize = 25.sp,
            color = White,
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp)
            )
        Spacer(modifier = Modifier.height(20.dp))
        Header()

    }
}

@Composable
private fun Header() {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .size(60.dp)
                .clip(shape = CircleShape)
                .border(1.dp, color = Color.Cyan, CircleShape)
        )
        Column {
            Text(
                text = "Karun Kumar",
                fontSize = 15.sp,
                color = White
            )
            Text(
                text = "karunkumar02525@gmail.com",
                fontSize = 13.sp,
                color = White.copy(0.7f),
                modifier = Modifier.padding(top = 4.dp)

            )
        }
    }
}