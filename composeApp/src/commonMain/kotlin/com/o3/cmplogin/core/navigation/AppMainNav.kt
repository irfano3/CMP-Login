package com.o3.cmplogin.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.o3.cmplogin.core.presentation.screens.dashboard.dashboardScreenCompose
import com.o3.cmplogin.core.presentation.screens.login.loginScreenCompose
import com.o3.cmplogin.core.presentation.screens.signup.signUpScreenCompose
import com.o3.cmplogin.core.presentation.screens.splash.splashScreenCompose

@Composable
fun AppMainNav(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen
    ) {

        splashScreenCompose(navController)
        signUpScreenCompose(navController)
        loginScreenCompose(navController)
        dashboardScreenCompose(navController)
    }
}