package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material3.MaterialTheme

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Pokedex") {
        MaterialTheme {
            App()
        }
    }
}
