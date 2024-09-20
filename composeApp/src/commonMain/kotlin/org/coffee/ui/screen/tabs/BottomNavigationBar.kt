package org.coffee.ui.screen.tabs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.coffee.CoffeeBTN
import org.coffee.CoffeeBg

@Composable
fun BottomNavigationBar(onTab:(Int)->Unit) {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Favorite", Icons.Default.Favorite),
        NavItem("Cart", Icons.Default.ShoppingCart),
        NavItem("Profile", Icons.Default.Person),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = CoffeeBg,
        contentColor = CoffeeBTN,
        tonalElevation=2.dp,
        modifier = Modifier
            .graphicsLayer {
                shape= RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
                clip=true
            }
    ) {
        navItemList.forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = selectedIndex==index,
                onClick = {
                    selectedIndex = index
                    onTab(selectedIndex)
                },
                icon={
                    Icon(imageVector = navItem.icon, contentDescription = "icon")
                },
                label = {
                    Text(text = navItem.label)
                }
            )
        }
    }
}

data class NavItem(
    val label:String,
    val icon: ImageVector
)
