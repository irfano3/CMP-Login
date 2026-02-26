package com.o3.cmplogin.project

import androidx.compose.ui.window.ComposeUIViewController
import com.o3.cmplogin.di.koinInit

fun MainViewController() = ComposeUIViewController (
    configure = {
        koinInit()
    }
    ) {
    App()
}