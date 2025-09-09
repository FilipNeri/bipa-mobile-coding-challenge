package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filipeneri.bipamobilecodingchallenge.R
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.ui.theme.Yellow
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel

@Composable
fun ErrorNode(mainViewModel: MainViewModel) {
    val uiState by mainViewModel.uiState.collectAsState()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Yellow,
        ),
        modifier = Modifier
            .size(width = 340.dp, height = 200.dp),


        ) {
        Column(modifier = Modifier.padding(8.dp).fillMaxSize(),Arrangement.Center, Alignment.CenterHorizontally) {
            Text(
                text = uiState.msgError,
                fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp

            )

        }

    }
}