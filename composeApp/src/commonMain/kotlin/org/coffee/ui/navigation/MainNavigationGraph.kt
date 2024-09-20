package org.coffee.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.coffee.ui.graphs.SubGraph
import org.coffee.ui.graphs.authNavGraph
import org.coffee.ui.graphs.mainNavGraph


@Composable
fun MainNavigationGraph(isLoggedIn:Boolean) {
    val navController = rememberNavController()
   // val isLoggedIn by viewmodel.isLogged.collectAsStateWithLifecycle()
    NavHost(
        navController = navController,
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.safeContent),
        startDestination = if (isLoggedIn) SubGraph.Dashboard else SubGraph.Auth,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(700)
            )
        }

    ) {
            mainNavGraph(navController)
            authNavGraph(navController)

    }
}
