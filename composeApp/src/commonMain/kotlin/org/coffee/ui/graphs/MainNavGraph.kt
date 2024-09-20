package org.coffee.ui.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.coffee.data.CoffeeModel
import org.coffee.ui.screen.MainScreen
import org.coffee.ui.screen.details.DetailsScreen
import org.coffee.ui.screen.filter.FilterScreen
import org.coffee.ui.screen.notification.NotificationScreen
import org.coffee.ui.screen.profile.ProfileScreen
import org.coffee.ui.screen.search.SearchScreen
import kotlin.reflect.typeOf


fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation<SubGraph.Dashboard>(startDestination = HomeDest.MainHome) {
        composable<HomeDest.MainHome> {
            MainScreen(navController)
        }

     /*   composable<HomeDest.Details>(
            typeMap = mapOf(
                typeOf<CoffeeModel>() to CustomNavType(
                    CoffeeModel::class, CoffeeModel.serializer()
                )
            )
        ) {
            val details: HomeDest.Details = it.toRoute<HomeDest.Details>()
            DetailsScreen(item = details.model, onGoBack = {
                navController.popBackStack()
            })
        }*/



      /*  composable<HomeDest.Profile> {
            val data = it.toRoute<HomeDest.Profile>()
            ProfileScreen(name = data.name, age = data.age) {
                navController.navigate(AuthScreen.Login) {
                    viewmodel.logOut()
                    popUpTo(0)
                }
            }
        }*/
        composable<HomeDest.Filter> {
            FilterScreen()
        }

        composable<HomeDest.Search> {
            SearchScreen()
        }

        composable<HomeDest.Notification> {
            NotificationScreen()
        }
    }
}


sealed interface HomeDest {

    @Serializable
    data object MainHome : HomeDest

    @Serializable
    data class Details(val model: CoffeeModel) : HomeDest

    @Serializable
    data object Filter : HomeDest

    @Serializable
    data object Search : HomeDest

    @Serializable
    data object Notification : HomeDest
}


/*
Dashboard(
navController=navController,
onFilterClick = {
    navController.navigate(HomeDest.Filter)
},
onSearchClick = {
    navController.navigate(HomeDest.Search)
},
onDetailClick = { item ->
    navController.navigate(HomeDest.Details(model = item))
}
)*/
