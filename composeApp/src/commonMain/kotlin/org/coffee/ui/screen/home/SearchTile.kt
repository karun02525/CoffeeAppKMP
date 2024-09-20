package org.coffee.ui.screen.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.filter
import coffeeappkmp.composeapp.generated.resources.ic_search
import org.coffee.FilterColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun SearchTile(modifier: Modifier=Modifier,
               onSearchClick:()->Unit={},
               onFilterClick:()->Unit={}
               ) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.CenterStart)
                    .size(30.dp)
            )

            Text(
                modifier = Modifier
                    .clickable { onSearchClick() }
                    .align(Alignment.CenterStart)
                    .padding(start = 60.dp),
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                text = "Search..."
            )


            Image(
                painter = painterResource(Res.drawable.filter),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { onFilterClick() }
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
                    .size(40.dp)
                    .background(FilterColor, shape = RoundedCornerShape(7.dp))
                    .padding(12.dp)
            )
        }
    }
}

