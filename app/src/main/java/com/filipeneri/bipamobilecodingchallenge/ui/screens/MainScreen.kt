package com.filipeneri.bipamobilecodingchallenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.lifecycle.ViewModel
import com.filipeneri.bipamobilecodingchallenge.R
import com.filipeneri.bipamobilecodingchallenge.model.City
import com.filipeneri.bipamobilecodingchallenge.model.Country
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.ui.components.CardNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.ErrorNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.ItemNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.ListNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.Loading
import com.filipeneri.bipamobilecodingchallenge.ui.theme.Yellow
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel
import com.filipeneri.bipamobilecodingchallenge.utils.Converters.Companion.converterToDate
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.nio.file.WatchService
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val uiState by mainViewModel.uiState.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { mainViewModel.getNodes() },
        indicator = {state, refreshTrigger ->
            SwipeRefreshIndicator(state = state, refreshTriggerDistance = refreshTrigger, backgroundColor = Yellow, contentColor = Color.White)

        }
    ) {
        Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
            if (uiState.isLoading) {
                Loading()
            } else {
                if (uiState.msgError.isBlank()) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp), Arrangement.Center
                    ) {
                        if (uiState.nodes.isNotEmpty()) {
                            CardNode(uiState.nodes[uiState.selected], mainViewModel)
                        }
                    }
                    ListNode(uiState.nodes, mainViewModel)
                } else {
                    ErrorNode(mainViewModel = mainViewModel)
                }
            }
        }
    }
}


