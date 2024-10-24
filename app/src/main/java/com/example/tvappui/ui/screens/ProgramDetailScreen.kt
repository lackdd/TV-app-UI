package com.example.tvappui.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.tvappui.ui.components.VideoPlayer

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ProgramDetailScreen(programName: String, videoUri: Uri, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0F))
    ) {
        Text(
            text = "$programName info",
            color = Color(0xFFE8EAED),
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = { onBackClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF727375))
        ) {
            Text(
                text = "Tagasi koju",
                color = Color(0xFFE8EAED)
            )
        }

        VideoPlayer(videoUri = videoUri)
    }
}