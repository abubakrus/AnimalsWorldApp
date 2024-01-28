package com.example.animalsworldapp.music_service

import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.Job
import javax.inject.Inject

class MusicServiceHandler @Inject constructor(
    private val player: ExoPlayer,
) : Player.Listener {

    init {
        player.addListener(this)
    }

    private var job: Job? = null

    fun addMediaItem(mediaItem: MediaItem) {
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    suspend fun playOrPause() {
        if (player.isPlaying) {
            player.pause()
        } else {
            player.play()
            Log.d("Abu", "player.play: ${player.isPlaying}")
        }
    }

}