package com.o3.cmplogin.core.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import com.o3.cmplogin.core.utils.sdp
import com.o3.cmplogin.core.utils.ssp

@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(24.sdp),
        modifier = modifier
    ) {
        Text(text = text, fontSize = 16.ssp)
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedButtonPreview() {
    MaterialTheme {
        RoundedButton(
            text = "Login",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.sdp),
            backgroundColor = Color.Black,
            contentColor = Color.White
        )
    }
}