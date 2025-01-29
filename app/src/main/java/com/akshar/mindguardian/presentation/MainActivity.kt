package com.akshar.mindguardian.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.akshar.mindguardian.core.theme.MindGuardianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindGuardianTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    Greeting("MindGuardian")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Hello $name!", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Hello $name!", style = MaterialTheme.typography.bodyLarge)
    }
}