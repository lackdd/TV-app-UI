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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(onProgramClick: (String, Uri) -> Unit) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Color(0xFF0E0E0F))
                .padding(top = 100.dp, start = 16.dp, end = 16.dp)
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
                programs = listOf("Sari 1", "Sari 2", "Sari 3", "Sari 4", "Sari 5", "Sari 6", "Sari 7", "Sari 8", "Sari 9", "Sari 10"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2")
                ),
                images = listOf(
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3,
                    R.drawable.img4,
                    R.drawable.img5,
                    R.drawable.img6,
                    R.drawable.img7,
                    R.drawable.img8,
                    R.drawable.img9,
                    R.drawable.img10
                ),
                onProgramClick = onProgramClick
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Hiliseim",
                color = Color(0xFFE8EAED),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            ProgramList(
                programs = listOf("Sari 11", "Sari 12", "Sari 13", "Sari 14", "Sari 15", "Sari 16", "Sari 17", "Sari 18", "Sari 19", "Sari 20"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2"),
                    Uri.parse("android.resource://${context.packageName}/raw/vid2")
                ),
                images = listOf(
                    R.drawable.img11,
                    R.drawable.img12,
                    R.drawable.img13,
                    R.drawable.img14,
                    R.drawable.img15,
                    R.drawable.img16,
                    R.drawable.img17,
                    R.drawable.img18,
                    R.drawable.img19,
                    R.drawable.img20
                ),
                onProgramClick = onProgramClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        NavigationBar(modifier = Modifier.align(Alignment.TopEnd))
    }
}