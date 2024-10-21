package com.example.tvappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.compose.ui.viewinterop.AndroidView
import android.net.Uri

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
                programs = listOf("Komissar Rex", "Troonide Mäng", "Dexter"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/rexv"),
                    Uri.parse("android.resource://${context.packageName}/raw/rexv"),
                    Uri.parse("android.resource://${context.packageName}/raw/rexv")
                ),
                images = listOf(
                    R.drawable.rex,
                    R.drawable.got,
                    R.drawable.dex
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
                programs = listOf("Stargate SG1", "Walking Dead", "Gray's anatomy"),
                videos = listOf(
                    Uri.parse("android.resource://${context.packageName}/raw/rexv"),
                    Uri.parse("android.resource://${context.packageName}/raw/rexv"),
                    Uri.parse("android.resource://${context.packageName}/raw/rexv")
                ),
                images = listOf(
                    R.drawable.sg1,
                    R.drawable.walk,
                    R.drawable.gray
                ),
                onProgramClick = onProgramClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        NavigationBar(modifier = Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun VideoPlayer(videoUri: Uri) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context).build().apply {
        val mediaItem = MediaItem.fromUri(videoUri)
        setMediaItem(mediaItem)
        prepare()
        playWhenReady = true
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            PlayerView(context).apply {
                player = exoPlayer
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ImageButton(imageResource: Int, contentDescription: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProgramList(programs: List<String>, videos: List<Uri>, images: List<Int>, onProgramClick: (String, Uri) -> Unit) {
    LazyRow {
        itemsIndexed(programs) { index, program ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onProgramClick(program, videos[index]) }
            ) {
                Image(
                    painter = painterResource(id = images[index]),
                    contentDescription = "$program thumbnail",
                    modifier = Modifier.size(150.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

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

@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ImageButton(
            imageResource = R.drawable.home,
            contentDescription = "Kodu",
            onClick = { /*navigate to home screen*/ },
        )
        ImageButton(
            imageResource = R.drawable.profile,
            contentDescription = "Profile",
            onClick = { /*navigate to home screen*/ },
        )
        ImageButton(
            imageResource = R.drawable.settings,
            contentDescription = "Settings",
            onClick = { /*navigate to home screen*/ },
        )
    }
}