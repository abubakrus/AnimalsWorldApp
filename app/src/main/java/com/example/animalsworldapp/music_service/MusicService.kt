package com.example.animalsworldapp.music_service

import android.content.Intent
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject



const val DEFAULT_LONG = 0L

@AndroidEntryPoint
class MusicService @Inject constructor(
    private val mediaSession: MediaSession,
) : MediaSessionService() {

    @UnstableApi
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession =
        mediaSession

    override fun onDestroy() {
        super.onDestroy()
        mediaSession.apply {
            release()
            if (player.playbackState != Player.STATE_IDLE) {
                player.seekTo(DEFAULT_LONG)
                player.playWhenReady = false
                player.stop()
            }
        }
    }
}