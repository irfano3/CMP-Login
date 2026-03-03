package com.o3.cmplogin.core.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cmplogin.composeapp.generated.resources.Res
import cmplogin.composeapp.generated.resources.compose_multiplatform
import cmplogin.composeapp.generated.resources.splash_bg
import com.o3.cmplogin.core.navigation.Routes
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashEffect
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashIntent
import com.o3.cmplogin.core.utils.config.AppSpacer
import com.o3.cmplogin.core.utils.sdp
import com.o3.cmplogin.core.utils.ssp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun SplashScreen(
    onNavigate: (destination: Routes) -> Unit
) {
    val viewModel: SplashViewModel = koinInject()
    val platform = viewModel.getPlatformName()

    LaunchedEffect(Unit) {
        delay(3000)
        viewModel.onIntent(SplashIntent.OnSplashComplete)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateToDashboard ->
                    onNavigate(Routes.DashboardScreen)

                SplashEffect.NavigateToLogin ->
                    onNavigate(Routes.LoginScreen)
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(Res.drawable.splash_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.sdp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null
            )

            AppSpacer(24.sdp)

            Text(text = platform, fontSize = 20.ssp)

            AppSpacer(16.sdp)

            Text(text = "Splash Screen", fontSize = 16.ssp)
        }
    }
}