package com.example.tvappui.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.tvappui.ui.components.ProgramList
import com.example.tvappui.ui.components.NavigationBar
import com.example.tvappui.R

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(onProgramClick: (String, Uri) -> Unit) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E0E0F))
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            /*Text(
                text = "Rakendused",
                color = Color(0xFFE8EAED),
                modifier = Modifier.padding(bottom = 16.dp)
            )*/
            Text(
                text = "Populaarne",
                color = Color(0xFFE8EAED),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            ProgramList(
                programs = listOf("Sari 1", "Sari 2", "Film 1"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2")
                ),
                images = listOf(
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three
                ),
                onProgramClick = onProgramClick
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hiliseim",
                color = Color(0xFFE8EAED),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            ProgramList(
                programs = listOf("Film 2", "Sari 3", "Sari 4"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2")
                ),
                images = listOf(
                    R.drawable.four,
                    R.drawable.five,
                    R.drawable.six
                ),
                onProgramClick = onProgramClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        NavigationBar(modifier = Modifier.align(Alignment.TopEnd))
    }
}