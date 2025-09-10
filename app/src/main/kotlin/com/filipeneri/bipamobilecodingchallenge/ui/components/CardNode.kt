package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.filipeneri.bipamobilecodingchallenge.model.City
import com.filipeneri.bipamobilecodingchallenge.model.Country
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.ui.theme.Yellow
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel

@Composable
fun CardNode(
    node: Node,
    mainViewModel: MainViewModel
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier
            .size(width = 340.dp, height = 200.dp),


    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
                Text(
                    text = node.alias,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Center
                )
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "channels:" + node.channels.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
            Row(modifier = Modifier, Arrangement.Start) {

                Text(
                    modifier = Modifier.padding(5.dp),
                    text = mainViewModel.convertSatsToBitcoin(node.capacity),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = " satts",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "First Seen : " + mainViewModel.convertLongToTime(node.firstSeen),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Last Update : " + mainViewModel.convertLongToTime(node.updatedAt),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )

            Row(modifier = Modifier.fillMaxWidth(), Arrangement.End) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = mainViewModel.formatCityCountry(node.city,node.country),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}