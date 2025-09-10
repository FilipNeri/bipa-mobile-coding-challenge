package com.filipeneri.bipamobilecodingchallenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.filipeneri.bipamobilecodingchallenge.ui.components.CardNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.ErrorDialog
import com.filipeneri.bipamobilecodingchallenge.ui.components.ListNode
import com.filipeneri.bipamobilecodingchallenge.ui.components.Loading
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val uiState by mainViewModel.uiState.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { mainViewModel.getNodes() },
        indicator = { state, refreshTrigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTrigger,
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                uiState.isLoading -> {
                    Loading()
                }
                uiState.msgError.isNotBlank() -> {
                    ErrorDialog(
                        mainViewModel = mainViewModel,
                        onDismiss = { mainViewModel.clearError() }
                    )
                }
                else -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        if (uiState.nodes.isNotEmpty()) {
                            CardNode(uiState.nodes[uiState.selected], mainViewModel)
                        }
                    }
                    ListNode(uiState.nodes, mainViewModel)
                }
            }
        }
    }
}


