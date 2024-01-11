package com.example.animalsworldapp.presentation.screens.edit_profile

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.EditTextField
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.extensions.getCapturedImage
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen
import com.example.animalsworldapp.presentation.screens.profile.models.CircularImage
import com.example.animalsworldapp.presentation.theme.Blue
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing


const val EDIT_PROFILE_ROUTE = "edit_profile_route"
private const val IMAGE_PICKER = "image/*"

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    uiState: EditProfileUiState,
    onEvent: (EditProfileOnEvent) -> Unit,
    navHostController: NavHostController
) {
    Scaffold(topBar = {
        TabBar(
            title = stringResource(id = R.string.edit_profile),
            alignment = Alignment.TopCenter,
            startIcon = Icons.Default.ArrowBack,
            startIconClick = { navHostController.navigateUp() },
            endIcon = Icons.Default.Save,
            endIconClick = { onEvent(EditProfileOnEvent.OnSaveClick) }
        )
    }) { innerPaddings ->


        when (uiState) {
            is EditProfileUiState.Initial -> Unit
            is EditProfileUiState.Content -> LoadedEditProfile(
                uiState = uiState, onEvent = onEvent, modifier = modifier.padding(innerPaddings)
            )

            is EditProfileUiState.Loading -> LoadingScreen()
            is EditProfileUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})

        }
    }

}


@Composable
fun LoadedEditProfile(
    modifier: Modifier = Modifier,
    uiState: EditProfileUiState.Content,
    onEvent: (EditProfileOnEvent) -> Unit
) {
    val isAvatarPlaceholder = remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerHeight(36.dp)
        UserAvatar(
            avatar = "",
            onAvatarChanged = { onEvent(EditProfileOnEvent.OnAvatarChanged(it)) })
        SpacerHeight(48.dp)
        EditTextField(
            value = uiState.nickName,
            hint = stringResource(id = R.string.email_hint),
            topText = stringResource(id = R.string.your_email),
            onValueChange = { onEvent(EditProfileOnEvent.OnNickNameChanged(it)) }
        )
        SpacerHeight(ExtraLargeSpacing)
        EditTextField(
            value = uiState.name,
            hint = stringResource(id = R.string.name_hint),
            topText = stringResource(id = R.string.your_name),
            onValueChange = { onEvent(EditProfileOnEvent.OnNamedChanged(it)) }
        )
        SpacerHeight(ExtraLargeSpacing)
        EditTextField(
            value = uiState.lastName,
            hint = stringResource(id = R.string.lastName_hint),
            topText = stringResource(id = R.string.your_lastName),
            onValueChange = { onEvent(EditProfileOnEvent.OnLastNamedChanged(it)) }
        )
        SpacerHeight(ExtraLargeSpacing)
        EditTextField(
            value = uiState.about,
            isSingleLine = false,
            hint = stringResource(id = R.string.about_hint),
            topText = stringResource(id = R.string.about_me),
            onValueChange = { onEvent(EditProfileOnEvent.OnAboutChanged(it)) }
        )
    }
}


@Composable
fun UserAvatar(
    avatar: String?,
    onAvatarChanged: (Bitmap) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var isAvatarPlaceholder by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> uri?.let { imageUri = it } }

    )
    LaunchedEffect(key1 = imageUri) {
        if (imageUri != null) {
            bitmap = imageUri.getCapturedImage(context)?.apply { onAvatarChanged(this) }
        }
    }
    Box(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
    ) {
        CircularImage(
            modifier = Modifier.clickable {
                isAvatarPlaceholder = !isAvatarPlaceholder
            },
            path = bitmap ?: avatar, size = 120
        )
        AnimatedVisibility(
            visible = isAvatarPlaceholder,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Blue.copy(alpha = 0.5f))
                    .clickable {
                        galleryLauncher.launch(IMAGE_PICKER)
                        isAvatarPlaceholder = false
                    },
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.PhotoCamera,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}


@Composable
fun UploadDialog(
    progress: Int,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "Progress = $progress",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}