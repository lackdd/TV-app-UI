package com.example.tvappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.tvappui.ui.theme.TVAppUITheme
import com.example.tvappui.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TVAppUITheme {
                AppNavigation()
            }
        }
    }
}
