package org.coffee.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffeeappkmp.composeapp.generated.resources.Res
import coffeeappkmp.composeapp.generated.resources.profile
import org.coffee.FilterColor
import org.coffee.GraySelection
import org.coffee.StarColor
import org.coffee.data.CoffeeModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailsScreen(
    item: CoffeeModel,
    onGoBack: () -> Unit = {}
) {
   // val item = getListCoffee().first { it.id == id }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Header(item = item, onGoBack = onGoBack, onFav = {})
        Title(item)
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 0.2.dp)
        Spacer(modifier = Modifier.height(20.dp))
        Description()
        Spacer(modifier = Modifier.height(30.dp))
        SelectSize()
        Spacer(modifier = Modifier.height(30.dp))
        CheckOut(item)
    }

}


@Composable
private fun Description() {

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),

        ) {
        Text(
            "Description",
            modifier = Modifier
                .padding(top = 5.dp),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Coffee is a beverage prepared from roasted coffee beans. It's also a plant (Coffea) and the name of the drink that is made from this plant. The coffee plant is a bush or tree that can grow up to ten meters (about 32 feet) high, but is usually cut shorter.",
            modifier = Modifier
                .padding(top = 10.dp),
            color = Color.Black.copy(0.5f),
            fontSize = 13.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
private fun Title(
    item: CoffeeModel
) {

    Box(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            item.title,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.TopStart),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            item.desc,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 30.dp),
            color = Color.Black.copy(0.5f),
            fontSize = 13.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.TopEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.Star,
                contentDescription = "",
                tint = StarColor,
                modifier = Modifier
                    .padding(end = 3.dp)
                    .size(20.dp)
            )

            Text(
                "" + item.star,
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                " (${item.rating}) ",
                color = Color.Black.copy(0.5f),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }

}


@Composable
private fun Header(
    item: CoffeeModel,
    onGoBack: () -> Unit,
    onFav: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Icon(
            Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "",
            tint = Color.Black,
            modifier = Modifier
                .clickable { onGoBack() }
                .align(Alignment.TopStart)
                .padding(start = 10.dp, top = 40.dp)
                .size(30.dp)
        )

        Icon(
            Icons.Default.FavoriteBorder,
            contentDescription = "",
            tint = Color.Black,
            modifier = Modifier
                .clickable { onFav() }
                .align(Alignment.TopEnd)
                .padding(end = 20.dp, top = 40.dp)
                .size(30.dp)
        )
    }
}

@Composable
private fun SelectSize() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        View(true, "S")
        View(false, "M")
        View(false, "L")
    }
}

@Composable
private fun View(
    isSelected: Boolean = false,
    name: String = "L",
) {
    Text(
        name,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isSelected) FilterColor else GraySelection,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 8.dp, horizontal = 40.dp),
        color = if (isSelected) FilterColor else GraySelection,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun CheckOut(
    item: CoffeeModel,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 15.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Text(
                "Total price",
                modifier = Modifier,
                fontSize = 16.sp,
                color = Color.Black.copy(0.7f),
            )
            Text(
                "₹${item.price}",
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 20.sp,
                color = FilterColor,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {},
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(containerColor = FilterColor)
        ) {
            Text("Payment", color = Color.White)
        }
    }
}
