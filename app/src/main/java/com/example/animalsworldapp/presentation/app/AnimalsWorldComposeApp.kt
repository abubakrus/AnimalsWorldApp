package com.example.animalsworldapp.presentation.app

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.animalsworldapp.presentation.navigation.AppNavGraph
import kotlinx.coroutines.flow.Flow


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalsWorldComposeApp(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    navigateToLocation: (String) -> Unit,
    destinationFlow: Flow<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    val (destination, isClearBackStack) = destinationFlow.collectAsState(initial = "" to false).value

    if (destination.isNotEmpty()) {
        navHostController.navigate(destination) {
            if (isClearBackStack) popUpTo(0)
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddings ->
        AppNavGraph(
            navHostController = navHostController,
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,
            navigateToLocation = {
                navigateToLocation(it)
            }
        )
    }
}