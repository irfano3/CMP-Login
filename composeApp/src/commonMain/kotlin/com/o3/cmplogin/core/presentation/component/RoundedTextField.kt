package com.o3.cmplogin.core.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cmplogin.composeapp.generated.resources.Res
import cmplogin.composeapp.generated.resources.ic_visibility
import cmplogin.composeapp.generated.resources.ic_visibility_off
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpState
import org.jetbrains.compose.resources.painterResource

@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    onTrailingIconClick: (() -> Unit)? = null
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },

        visualTransformation =
            if (isPassword && !isPasswordVisible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,

        trailingIcon = {
            if (isPassword) {
                Icon(
                    painter = painterResource(
                        if (isPasswordVisible)
                            Res.drawable.ic_visibility
                        else
                            Res.drawable.ic_visibility_off
                    ),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        onTrailingIconClick?.invoke()
                    }
                )
            }
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),

        shape = RoundedCornerShape(16.dp),
        modifier = modifier.fillMaxWidth()
    )
}