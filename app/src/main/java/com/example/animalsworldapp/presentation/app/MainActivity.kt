package com.example.animalsworldapp.presentation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.animalsworldapp.presentation.theme.AnimalsWorldAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalsWorldAppTheme {
                AnimalsWorldComposeApp(destinationFlow = viewModel.destinationFlow)
            }
        }
    }
}