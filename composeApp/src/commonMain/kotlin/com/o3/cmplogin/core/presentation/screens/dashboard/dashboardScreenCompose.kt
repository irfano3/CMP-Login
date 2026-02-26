package com.o3.cmplogin.core.presentation.screens.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.o3.cmplogin.core.navigation.Routes

fun NavGraphBuilder.dashboardScreenCompose(
    navController: NavController
) {

    composable<Routes.DashboardScreen> {
        DashboardScreen(

        )
    }
}