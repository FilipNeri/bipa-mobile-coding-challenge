package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel

@Composable
fun ErrorDialog(
    mainViewModel: MainViewModel,
    onDismiss: () -> Unit
) {
    val uiState by mainViewModel.uiState.collectAsState()
    if (uiState.msgError.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            containerColor = MaterialTheme.colorScheme.error,
            title = {
                Text(
                    text = "Erro",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onError
                )
            },
            text = {
                Text(
                    text = uiState.msgError,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onError,
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(
                        text = "OK",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onError,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}