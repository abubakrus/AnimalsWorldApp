package com.example.animalsworldapp.music_service

import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import javax.inject.Inject

class MusicServiceHandler @Inject constructor(private val player: ExoPlayer) : Player.Listener {

    init {
        player.addListener(this)
    }

    fun addMediaItem(mediaItem: MediaItem) {
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    fun playOrPause() {
        if (player.isPlaying) player.pause()
        else player.play()
    }
}