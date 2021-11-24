package me.bytebeats.compose.bitcoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.bytebeats.compose.bitcoin.navigation.ComposeBitcoinApp
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBitcoinTheme {
                // A surface container using the 'background' color from the theme
                ComposeBitcoinApp()
            }
        }
    }
}