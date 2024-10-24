package com.example.tvappui.ui.navigation

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.tvappui.ui.screens.HomeScreen
import com.example.tvappui.ui.screens.ProgramDetailScreen

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppNavigation() {
    var selectedProgram by remember { mutableStateOf<String?>(null) }
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0F))
            .padding(16.dp)
    ) {
        when (selectedProgram) {
            null -> HomeScreen { programName, videoUri ->
                selectedProgram = programName
                selectedVideoUri = videoUri
            }

            else -> ProgramDetailScreen(programName = selectedProgram!!, videoUri = selectedVideoUri!!) {
                selectedProgram = null
                selectedVideoUri = null
            }
        }
    }
}