package com.o3.cmplogin.core.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmplogin.composeapp.generated.resources.Res
import cmplogin.composeapp.generated.resources.compose_multiplatform
import cmplogin.composeapp.generated.resources.splash_bg
import com.o3.cmplogin.core.navigation.Routes
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashEffect
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashIntent
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun SplashScreen(
    onNavigate: (destination: Routes) -> Unit
) {
    val viewModel: SplashViewModel = koinInject()
    val platform = viewModel.getPlatformName()

    // Start the Splash Intent
    LaunchedEffect(Unit) {
        viewModel.onIntent(SplashIntent.Start)
    }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateToDashboard -> onNavigate(Routes.LoginScreen)
                SplashEffect.NavigateToLogin -> onNavigate(Routes.LoginScreen)
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = platform, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Splash Screen", fontSize = 16.sp)
        }
    }
}