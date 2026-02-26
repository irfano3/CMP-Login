package com.o3.cmplogin

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.o3.cmplogin.di.koinInit
import com.o3.cmplogin.project.App

fun main() = application {
    koinInit()
    Window(
        onCloseRequest = ::exitApplication,
        title = "CmpLogin",
    ) {
        App()
    }
}