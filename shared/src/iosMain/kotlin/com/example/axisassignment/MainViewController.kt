package com.example.axisassignment

import androidx.compose.ui.window.ComposeUIViewController
import com.example.axisassignment.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }