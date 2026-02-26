package com.o3.cmplogin.core.presentation.screens.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.o3.cmplogin.core.navigation.Routes

fun NavGraphBuilder.loginScreenCompose(
    navController: NavHostController
) {

    composable<Routes.LoginScreen> {
        LoginScreen(
            onSignUpClick = {
                navController.navigate(Routes.SignUpScreen)
            },
            onNavigateToDashboard = {
                navController.navigate(Routes.DashboardScreen) {
                    popUpTo(Routes.LoginScreen) { inclusive = true }
                }
            }
        )
    }
}