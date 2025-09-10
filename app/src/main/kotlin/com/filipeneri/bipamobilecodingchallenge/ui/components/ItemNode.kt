package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filipeneri.bipamobilecodingchallenge.R
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel

@Composable
fun ItemNode(
    node: Node,
    index:Int,
    mainViewModel: MainViewModel
) {
    val uiState by mainViewModel.uiState.collectAsState()
    Button(
        onClick = { mainViewModel.setSelected(index)},
        colors = ButtonDefaults.buttonColors(
            if (uiState.selected == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),

    ) {
            Text(
                text = node.alias,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(5.dp).weight(1F),
                textAlign = TextAlign.Start
            )
            Text(
                text = node.publicKey,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(5.dp)
                    .width(120.dp),
                textAlign = TextAlign.End
            )

    }
}