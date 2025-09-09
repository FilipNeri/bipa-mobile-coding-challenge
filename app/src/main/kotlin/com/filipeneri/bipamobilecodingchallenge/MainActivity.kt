package com.filipeneri.bipamobilecodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.filipeneri.bipamobilecodingchallenge.ui.screens.MainScreen
import com.filipeneri.bipamobilecodingchallenge.ui.theme.BIPAMobileCodingChallengeTheme
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BIPAMobileCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenNavigation()
                }
            }
        }
    }

    @Composable
    private fun MainScreenNavigation() {
        val mainViewModel = koinViewModel<MainViewModel>()
        MainScreen(mainViewModel)
    }
}