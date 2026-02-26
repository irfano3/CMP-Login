package com.o3.cmplogin.core.presentation.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpEffect
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpIntent
import com.o3.cmplogin.project.showToast
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun SignUpScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: () -> Unit
) {
    val viewModel: SignUpViewModel = koinInject()
    val state = viewModel.state

    LaunchedEffect(viewModel) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                SignUpEffect.NavigateToDashboard -> onNavigateToDashboard()
                SignUpEffect.NavigateToLogin -> onNavigateToLogin()
                is SignUpEffect.ShowError -> {
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
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign Up", fontSize = 25.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(100.dp))

            RoundedTextField(
                value = state.email,
                onValueChange = { viewModel.onIntent(SignUpIntent.EnterEmail(it)) },
                placeholder = "Enter Email"
            )

            Spacer(modifier = Modifier.height(12.dp))

            RoundedTextField(
                value = state.password,
                onValueChange = { viewModel.onIntent(SignUpIntent.EnterPassword(it)) },
                placeholder = "Enter Password",
                isPassword = true,
                isPasswordVisible = state.isPasswordVisible,
                onTrailingIconClick = { viewModel.onIntent(SignUpIntent.TogglePasswordVisibility) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            RoundedTextField(
                value = state.confirmPassword,
                onValueChange = { viewModel.onIntent(SignUpIntent.ConfirmPassword(it)) },
                placeholder = "Confirm Password",
                isPassword = true,
                isPasswordVisible = state.isConfirmPasswordVisible,
                onTrailingIconClick = { viewModel.onIntent(SignUpIntent.ToggleConfirmPasswordVisibility) }
            )

            Spacer(modifier = Modifier.height(40.dp))

            RoundedButton(
                text = "Sign Up",
                onClick = { viewModel.onIntent(SignUpIntent.Submit) },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text("Already have account? ")
                Text(
                    "Login",
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onNavigateToLogin() }
                )
            }
        }
    }
}