package com.example.tvappui.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import com.example.tvappui.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.tvappui.ui.components.VideoPlayer

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ProgramDetailScreen(programName: String, videoUri: Uri, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0F))
    ) {
        VideoPlayer(videoUri = videoUri)
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 60.dp)
                .clickable { onBackClick() }
                .size(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back to Home",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}