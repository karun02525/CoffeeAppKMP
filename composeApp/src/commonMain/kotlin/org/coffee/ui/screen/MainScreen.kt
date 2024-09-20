package org.coffee.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.coffee.ui.graphs.AuthScreen
import org.coffee.ui.graphs.HomeDest
import org.coffee.ui.screen.auth.koinViewModel
import org.coffee.ui.screen.profile.ProfileScreen
import org.coffee.ui.screen.tabs.BottomNavigationBar
import org.coffee.ui.screen.tabs.CartScreen
import org.coffee.ui.screen.tabs.FavoriteScreen
import org.coffee.ui.screen.tabs.HomeScreen
import org.coffee.ui.screen.tabs.ProfileScreen1
import org.coffee.viewmodel.AuthViewmodel

@Composable
fun MainScreen(navController: NavController) {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            BottomNavigationBar {
                selectedIndex = it
            }
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            ContentScreen(selectedIndex,navController)
        }
    }
}

@Composable
fun ContentScreen(selectedIndex: Int, navController: NavController) {
    when (selectedIndex) {
        0 -> {
            HomeScreen(
                onSearchClick = {  navController.navigate(HomeDest.Search)},
                onFilterClick = {  navController.navigate(HomeDest.Filter)},
                onDetailClick = {  navController.navigate(HomeDest.Details(model = it))},
                onNotificationClick = { navController.navigate(HomeDest.Notification) }
            )
        }

        1 -> FavoriteScreen()
        2 -> CartScreen()
        3 ->
        ProfileScreen1(logout = {
            navController.navigate(AuthScreen.Login) {
               // viewmodel.logOut()
                popUpTo(0)
            }
        })
    }
}