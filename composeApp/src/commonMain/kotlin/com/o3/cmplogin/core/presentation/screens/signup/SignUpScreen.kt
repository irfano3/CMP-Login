package com.o3.cmplogin.core.presentation.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import cmplogin.composeapp.generated.resources.Res
import cmplogin.composeapp.generated.resources.splash_bg
import com.o3.cmplogin.core.presentation.component.RoundedButton
import com.o3.cmplogin.core.presentation.component.RoundedTextField
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpEffect
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpIntent
import com.o3.cmplogin.core.utils.config.AppSpacer
import com.o3.cmplogin.core.utils.sdp
import com.o3.cmplogin.core.utils.ssp
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
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.sdp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign Up", fontSize = 25.ssp, fontWeight = FontWeight.Bold)

            AppSpacer(100.sdp)

            RoundedTextField(
                value = state.email,
                onValueChange = { viewModel.onIntent(SignUpIntent.EnterEmail(it)) },
                placeholder = "Enter Email"
            )

            AppSpacer(12.sdp)

            RoundedTextField(
                value = state.password,
                onValueChange = { viewModel.onIntent(SignUpIntent.EnterPassword(it)) },
                placeholder = "Enter Password",
                isPassword = true,
                isPasswordVisible = state.isPasswordVisible,
                onTrailingIconClick = { viewModel.onIntent(SignUpIntent.TogglePasswordVisibility) }
            )

            AppSpacer(12.sdp)

            RoundedTextField(
                value = state.confirmPassword,
                onValueChange = { viewModel.onIntent(SignUpIntent.ConfirmPassword(it)) },
                placeholder = "Confirm Password",
                isPassword = true,
                isPasswordVisible = state.isConfirmPasswordVisible,
                onTrailingIconClick = { viewModel.onIntent(SignUpIntent.ToggleConfirmPasswordVisibility) }
            )

            AppSpacer(40.sdp)

            RoundedButton(
                text = "Sign Up",
                onClick = { viewModel.onIntent(SignUpIntent.Submit) },
                modifier = Modifier.fillMaxWidth().height(50.sdp)
            )

            AppSpacer(16.sdp)

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