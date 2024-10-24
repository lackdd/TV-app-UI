package com.example.tvappui.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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