package org.coffee.ui.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import kotlinx.serialization.Serializable
import org.coffee.ui.screen.auth.ForgotPasswordScreen
import org.coffee.ui.screen.auth.LoginContent
import org.coffee.ui.screen.auth.RegisterScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController,) {
    navigation<SubGraph.Auth>(startDestination = AuthScreen.Login) {
        composable<AuthScreen.Login> {
            LoginContent(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(HomeDest.MainHome)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot)
                }
            )
        }

        composable<AuthScreen.SignUp> {
            RegisterScreen(
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<AuthScreen.Forgot> {
            ForgotPasswordScreen {
                navController.popBackStack()
            }
        }
    }
}


sealed interface AuthScreen{

    @Serializable
    data object Login: AuthScreen

    @Serializable
    data object SignUp: AuthScreen

    @Serializable
    data object Forgot: AuthScreen
}
