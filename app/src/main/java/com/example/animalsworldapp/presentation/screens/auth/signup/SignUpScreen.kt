package com.example.animalsworldapp.presentation.screens.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.LoginTextField
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.extensions.SpacerWidth
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.LargeBlue
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onEvent: (SignUpEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TabBar(title = stringResource(id = R.string.signup))
        }
    ) { innerPaddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddings)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(ExtraLargeSpacing)
            LoginTextField(
                text = uiState.name,
                onValueChange = { onEvent(SignUpEvent.OnNamedChanged(it)) },
                placeholder = stringResource(id = R.string.name)
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                text = uiState.lastName,
                onValueChange = { onEvent(SignUpEvent.OnLastNamedChanged(it)) },
                placeholder = stringResource(id = R.string.lastname)
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                text = uiState.email,
                onValueChange = { onEvent(SignUpEvent.OnEmailChanged(it)) },
                placeholder = stringResource(id = R.string.email)
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                text = uiState.password,
                onValueChange = { onEvent(SignUpEvent.OnPasswordChanged(it)) },
                placeholder = stringResource(id = R.string.password),
                isPassword = true
            )
            SpacerHeight(ExtraMediumSpacing)
            Button(
                onClick = {
                    onEvent(SignUpEvent.OnSignUpClick)
                },
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LargeBlue,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            )
            {
                Text(
                    modifier = Modifier.padding(vertical = MediumSpacing),
                    text = stringResource(id = R.string.signup),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            SpacerHeight(ExtraLargeSpacing)
            Row {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                SpacerWidth(SmallSpacing)
                Text(
                    modifier = Modifier.clickable { onEvent(SignUpEvent.OnLoginClick) },
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.bodyMedium,
                    color = LargeBlue
                )
            }
        }
    }
}

