package com.example.animalsworldapp.presentation.screens.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.LoginTextField
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSmallSpacing
import com.example.animalsworldapp.presentation.theme.LargeBlue
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
    navBackStackEntry: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TabBar(
                title = stringResource(id = R.string.login),
                startIcon = Icons.Default.ArrowBack,
                startIconClick = navBackStackEntry
            )
        }
    ) { innerPaddings ->
        if (uiState.isAuthentication) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
            }
        }
        Column(
            modifier = Modifier.padding(innerPaddings),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(size = ExtraLargeSpacing)
            LoginTextField(
                text = uiState.email,
                onValueChange = { value ->
                    onEvent(LoginEvent.OnEmailChanged(value))
                },
                placeholder = stringResource(id = R.string.login),
                isPassword = true
            )
            SpacerHeight(size = ExtraLargeSpacing)
            LoginTextField(
                text = "",
                onValueChange = { value ->
                    onEvent(LoginEvent.OnPasswordChanged(value))
                },
                placeholder = stringResource(id = R.string.password),
                isPassword = true
            )
            SpacerHeight(size = ExtraLargeSpacing)
            Button(
                onClick = {
                    onEvent(LoginEvent.OnLoginClick)
                },
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LargeBlue,
                    contentColor = MaterialTheme.colorScheme.onBackground

                )
            ) {
                Text(
                    modifier = Modifier.padding(vertical = SmallSpacing),
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            SpacerHeight(ExtraLargeSpacing)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.dont_have_anaccount),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.width(ExtraSmallSpacing))
                Text(
                    modifier = Modifier.clickable {
                        onEvent(LoginEvent.OnSignUpClick)
                    },
                    text = stringResource(id = R.string.signup),
                    style = MaterialTheme.typography.bodyLarge,
                    color = LargeBlue
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(uiState = LoginUiState(), onEvent = {}, navBackStackEntry = {})
    }
}