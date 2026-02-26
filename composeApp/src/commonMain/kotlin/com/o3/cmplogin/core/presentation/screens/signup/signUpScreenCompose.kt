package com.o3.cmplogin.core.presentation.screens.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.o3.cmplogin.core.navigation.Routes

fun NavGraphBuilder.signUpScreenCompose(
    navController: NavController
) {

    composable<Routes.SignUpScreen> {
        SignUpScreen(
            onNavigateToLogin = { navController.navigate(Routes.LoginScreen) },
            onNavigateToDashboard = {
                navController.navigate(Routes.DashboardScreen) {
                    popUpTo(Routes.LoginScreen) { inclusive = true }
                }
            }
        )
    }
}