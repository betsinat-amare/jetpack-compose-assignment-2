package com.example.todo_app.UI_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(
    onContinue: () -> Unit,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to TODO App!")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onContinue) {
            Text("Continue")
        }
    }
}
