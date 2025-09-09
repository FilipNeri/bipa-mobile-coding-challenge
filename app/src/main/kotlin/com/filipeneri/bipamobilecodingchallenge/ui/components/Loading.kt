package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.filipeneri.bipamobilecodingchallenge.ui.theme.Yellow
import com.filipeneri.bipamobilecodingchallenge.ui.theme.YellowLight

@Composable
fun Loading(){
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = Yellow,
        trackColor = YellowLight,
    )
}