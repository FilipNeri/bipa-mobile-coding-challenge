package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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

/*
fun CardNode(
    node: Node = Node(
        "0217890e3aad8d35bc054f43acc00084b25229ecff0ab68debd82883ad65ee8266",
        "1ML.com node ALPHA",
        1770,
        851808814,
        1529506821,
        1724283054,
        City(
            "New York City",
            "New York",
            "Nueva York",
            "New York",
            "ニューヨーク",
            "Nova Iorque",
            "Нью-Йорк",
            "美国"
        ),
        Country(
            "Vereinigte Staaten",
            "United States",
            "Estados Unidos",
            "États Unis",
            "アメリカ",
            "EUA",
            "США",
            "美国"
        )
    )
) {
*/
@Composable
//@Preview
fun CardNode(
    node: Node,
    mainViewModel: MainViewModel
) {
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
        Column(modifier = Modifier.padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
                Text(
                    text = node.alias,
                    fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp

                )
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "channels:" + node.channels.toString(),
                fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Row(modifier = Modifier, Arrangement.Start) {

                Text(
                    modifier = Modifier.padding(5.dp),
                    text = mainViewModel.convertSatsToBitcoin(node.capacity),
                    fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = " satts",
                    fontFamily = FontFamily(Font(R.font.pt_serif_italic, FontWeight.Normal)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "First Seen : " + mainViewModel.convertLongToTime(node.firstSeen),
                fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Last Update : " + mainViewModel.convertLongToTime(node.updatedAt),
                fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Row(modifier = Modifier.fillMaxWidth(), Arrangement.End) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = mainViewModel.formatCityCountry(node.city,node.country),
                    fontFamily = FontFamily(Font(R.font.pt_serif, FontWeight.Normal)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}