package org.coffee.ui.screen.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.arrow_drop_down
import coffeeappkmp.composeapp.generated.resources.header_bg
import coffeeappkmp.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.painterResource


@Composable
fun Header(
    onSearchClick:()->Unit={},
    onFilterClick:()->Unit={},
    onNotificationClick:()->Unit={}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.header_bg),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
            )

            Icon(
                imageVector = Icons.Default.Notifications,
                tint = Color.White,
                contentDescription = "",
                modifier = Modifier
                    .clickable { onNotificationClick() }
                    .padding(end = 20.dp, top = 20.dp)
                    .align(Alignment.TopEnd)
            )

            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.BottomStart),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    text = "Balaji Elite "
                )

                Row(
                    modifier = Modifier.padding(bottom = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        modifier = Modifier,
                        textAlign = TextAlign.End,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        text = "Bomosandra,BLR"
                    )

                    Image(
                        painter = painterResource(Res.drawable.arrow_drop_down),
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Image(
                painter = painterResource(Res.drawable.profile),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 50.dp, end = 15.dp)
                    .align(Alignment.BottomEnd)
                    .border(1.dp, color = Color.White, shape = RoundedCornerShape(5.dp))
                    .size(60.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
        }

        SearchTile(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .align(Alignment.BottomCenter),
            onSearchClick=onSearchClick,
            onFilterClick=onFilterClick
        )

    }
}

