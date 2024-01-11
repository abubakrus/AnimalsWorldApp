package com.example.animalsworldapp.presentation.screens.edit_profile

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.presentation.extensions.convertToByteArray
import com.example.animalsworldapp.presentation.extensions.firstLetterIsCapitalizedRestSmall
import com.example.animalsworldapp.presentation.models.User
import com.parse.ParseException
import com.parse.ParseFile
import com.parse.ProgressCallback
import com.parse.SaveCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


private const val DEFAULT_IMAGE_TITLE = "image.png"

@HiltViewModel
class EditProfileViewModel @Inject constructor(
) : ViewModel(), SaveCallback, ProgressCallback {

    private val _uiState = MutableStateFlow<EditProfileUiState>(EditProfileUiState.Initial)
    val uiState: StateFlow<EditProfileUiState> = _uiState.asStateFlow()

    private var parseFile: ParseFile? = null


    private val _uploadProgress = MutableStateFlow<AvatarUploadProgress?>(null)
    val uploadProgress: StateFlow<AvatarUploadProgress?> = _uploadProgress.asStateFlow()

    init {
        val user = User.unknown
        _uiState.tryEmit(
            EditProfileUiState.Content(
                name = user.name,
                lastName = user.lastName,
                nickName = user.nickName,
                about = user.about,
                contackWithMe = user.contactWithMe,
                location = user.location
            )
        )

    }


    fun onEvent(event: EditProfileOnEvent) {
        when (event) {
            is EditProfileOnEvent.OnSaveClick -> doSaveClick()
            is EditProfileOnEvent.OnAboutChanged -> doAboutChanged(event.value)
            is EditProfileOnEvent.OnNamedChanged -> doNamedChanged(event.value)
            is EditProfileOnEvent.OnLastNamedChanged -> doLastNamedChanged(event.value)
            is EditProfileOnEvent.OnNickNameChanged -> doEmailChanged(event.value)
            is EditProfileOnEvent.OnAvatarChanged -> doAvatarChanged(event.bitmap)
        }
    }

    private fun doSaveClick() {
        startSaveAvatar()
    }

    private fun startSaveAvatar() {
        val file = parseFile ?: return
        file.saveInBackground(this, this)
    }

    private fun doAvatarChanged(bitmap: Bitmap) {
        val byteArray = bitmap.convertToByteArray()
        parseFile = ParseFile(DEFAULT_IMAGE_TITLE, byteArray)
    }

    private fun doAboutChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(about = value)
        }
    }

    private fun doNamedChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(name = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    private fun doLastNamedChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(lastName = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    private fun doEmailChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(nickName = value.lowercase())
        }
    }

    override fun done(e: ParseException?) {
        Log.i("Abubakir", "ParseException = ${e?.stackTraceToString()}")
        _uploadProgress.tryEmit(null)
    }

    override fun done(percentDone: Int?) {
        val progress = percentDone ?: return
        val uploadProgress = AvatarUploadProgress(progress)
        _uploadProgress.tryEmit(uploadProgress)
    }

}