package com.example.animalsworldapp.presentation.app

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.animalsworldapp.presentation.screens.detail.DetailScreenViewModel
import com.example.animalsworldapp.presentation.theme.AnimalsWorldAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            AnimalsWorldAppTheme(darkTheme = darkTheme) {
                AnimalsWorldComposeApp(
                    destinationFlow = viewModel.destinationFlow,
                    darkTheme = darkTheme,
                    onThemeUpdated = { darkTheme = !darkTheme },
                    navigateToLocation = { location ->
                        val url = "http://maps.google.com/maps?q=$location"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    }
                )
            }
        }
    }
}