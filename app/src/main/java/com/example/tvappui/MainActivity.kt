package com.example.tvappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.material.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.tvappui.ui.theme.TVAppUITheme
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp

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

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppNavigation() {
    var selectedProgram by remember { mutableStateOf<String?>(null) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0F))
            .padding(16.dp)
    ) {
        when (selectedProgram) {
            null -> HomeScreen { programName ->
                selectedProgram = programName
            }

            else -> ProgramDetailScreen(programName = selectedProgram!!) {
                selectedProgram = null
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(onProgramClick: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E0E0F))
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = "Rakendused",
                color = Color(0xFFE8EAED),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            ProgramList(
                programs = listOf("Program 1", "Program 2", "Program 3"),
                onProgramClick = onProgramClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        NavigationBar(modifier = Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun ProgramList(programs: List<String>, onProgramClick: (String) -> Unit) {
    LazyColumn {
        items(programs) { program ->
            Text(
                text = program,
                color = Color(0xFFE8EAED),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onProgramClick(program) }
            )
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ProgramDetailScreen(programName: String, onBackClick: () -> Unit) {
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
    }
}

@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = { /*navigate to home screen*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF727375))
        ) {
            Text(text = "Kodu",
                color = Color(0xFFE8EAED))
        }
        Button(
            onClick = { /*navigate to home screen*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF727375))
        ) {
            Text(text = "Äpid",
                color = Color(0xFFE8EAED))
        }
        Button(
            onClick = { /*navigate to home screen*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF727375))
        ) {
            Text(text = "Seaded",
                color = Color(0xFFE8EAED))
        }
    }
}