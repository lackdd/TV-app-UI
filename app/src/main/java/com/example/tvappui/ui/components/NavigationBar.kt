package com.example.tvappui.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tvappui.R

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