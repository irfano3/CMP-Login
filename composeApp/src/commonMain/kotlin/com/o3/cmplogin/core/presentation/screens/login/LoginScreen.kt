package com.o3.cmplogin.core.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmplogin.composeapp.generated.resources.Res
import cmplogin.composeapp.generated.resources.splash_bg
import com.o3.cmplogin.core.presentation.component.RoundedButton
import com.o3.cmplogin.core.presentation.component.RoundedTextField
import com.o3.cmplogin.core.presentation.screens.login.model.LoginEffect
import com.o3.cmplogin.core.presentation.screens.login.model.LoginIntent
import com.o3.cmplogin.project.showToast
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit = {},
    onNavigateToDashboard: () -> Unit = {}
) {

    val viewModel: LoginViewModel = koinInject()
    val state = viewModel.state

    LaunchedEffect(viewModel) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                LoginEffect.NavigateToDashboard -> {
                    onNavigateToDashboard()
                }
                is LoginEffect.ShowError -> {
                    showToast(effect.message)
                }
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
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Login",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            RoundedTextField(
                value = state.email,
                onValueChange = { viewModel.onIntent(LoginIntent.EnterEmail(it)) },
                placeholder = "Enter Email"
            )

            Spacer(modifier = Modifier.height(12.dp))

            RoundedTextField(
                value = state.password,
                onValueChange = { viewModel.onIntent(LoginIntent.EnterPassword(it)) },
                placeholder = "Enter Password",
                isPassword = true,
                isPasswordVisible = state.isPasswordVisible,
                onTrailingIconClick = {
                    viewModel.onIntent(LoginIntent.TogglePasswordVisibility)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            RoundedButton(
                text = "Login",
                onClick = { viewModel.onIntent(LoginIntent.Submit) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(text = "I don't have account? ")
                Text(
                    text = "SignUp",
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onSignUpClick() }
                )
            }
        }
    }
}