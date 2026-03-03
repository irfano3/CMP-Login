package com.o3.cmplogin.core.presentation.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.o3.cmplogin.core.utils.config.AppSpacer
import com.o3.cmplogin.core.utils.sdp
import com.o3.cmplogin.core.utils.ssp
import org.koin.compose.koinInject

@Composable
fun DashboardScreen() {

    val viewModel: DashboardViewModel = koinInject()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = viewModel.email,
            fontSize = 22.ssp,
            fontWeight = FontWeight.Bold
        )

        AppSpacer(12.sdp)

        Text(
            text = viewModel.password,
            fontSize = 18.ssp
        )
    }
}