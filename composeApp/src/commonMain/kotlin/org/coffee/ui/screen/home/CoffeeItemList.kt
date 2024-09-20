package org.coffee.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.baseline_add_24
import coffeeappkmp.composeapp.generated.resources.profile
import org.coffee.FilterColor
import org.coffee.data.CoffeeModel
import org.coffee.data.CoffeeModel.Companion.getListCoffee
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun CoffeeItemList(
    onDetailClick:(CoffeeModel)->Unit={}
) {

    LazyVerticalGrid(
        modifier = Modifier.background(Color.White),
        columns = GridCells.Fixed(2), // Number of columns
        contentPadding = PaddingValues(8.dp)
    ) {
        items(getListCoffee()) { item ->
            Item(item){
                onDetailClick(item)
            }
        }
    }

}

@Composable
private fun Item(item: CoffeeModel,goToDetails:(CoffeeModel)->Unit={}) {
    Column(
        modifier = Modifier
            .clickable { goToDetails(item) }
            .padding(15.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.profile),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "",
                    tint = Color.Yellow,
                    modifier = Modifier
                        .padding(end = 3.dp)
                        .size(13.dp)
                )

                Text("" + item.star, color = Color.White)
            }
        }

        Text(
            item.title,
            modifier = Modifier.padding(top = 10.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            item.desc,
            modifier = Modifier.padding(top = 1.dp),
            color = Color.Black.copy(0.5f),
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "₹ ${item.price}",
                modifier = Modifier,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Image(
                painter = painterResource(Res.drawable.baseline_add_24),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .background(FilterColor, shape = RoundedCornerShape(10.dp))
                    .padding(8.dp)
            )

        }
    }

}