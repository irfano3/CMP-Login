package com.o3.cmplogin.core.presentation.screens.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.o3.cmplogin.core.navigation.Routes

fun NavGraphBuilder.splashScreenCompose(
    navController: NavController
) {
    composable<Routes.SplashScreen> {
        SplashScreen(
            onNavigate = { destination ->
                navController.navigate(destination) {
                    popUpTo(Routes.SplashScreen) { inclusive = true }
                }
            }
        )
    }
}

