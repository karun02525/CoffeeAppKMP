package org.coffee.ui.screen.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.coffee.data.CoffeeModel
import org.coffee.ui.screen.home.ChipTile
import org.coffee.ui.screen.home.CoffeeItemList
import org.coffee.ui.screen.home.Header

@Composable
fun HomeScreen(
    onDetailClick: (CoffeeModel) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onNotificationClick:()->Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header(onSearchClick = onSearchClick, onFilterClick = onFilterClick,onNotificationClick=onNotificationClick)
        Spacer(modifier = Modifier.height(20.dp))
        ChipTile()
        Spacer(modifier = Modifier.height(10.dp))
        CoffeeItemList(onDetailClick = onDetailClick)
    }

}