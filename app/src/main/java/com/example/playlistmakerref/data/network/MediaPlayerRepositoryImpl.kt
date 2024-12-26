package com.example.playlistmakerref.data.network

import android.media.MediaPlayer
import com.example.playlistmakerref.domain.api.PlayerInteractor
import com.example.playlistmakerref.domain.api.PlayerRepository
import com.example.playlistmakerref.domain.models.PlayerState
import com.example.playlistmakerref.domain.models.Track
import java.text.SimpleDateFormat
import java.util.Locale

class MediaPlayerRepositoryImpl: PlayerRepository {
    private val player = MediaPlayer()
    private var playerState: PlayerState = PlayerState.DEFAULT
    private lateinit var listener: PlayerInteractor.OnStateChangeListener

    override fun preparePlayer(listener: PlayerInteractor.OnStateChangeListener) {
        this.listener = listener
        player.prepareAsync()

        player.setOnPreparedListener {
            playerState = PlayerState.PREPARED
            listener.onChange(playerState)
        }

        player.setOnCompletionListener {
            playerState = PlayerState.PREPARED
            listener.onChange(playerState)
        }
    }

    override fun startPlayer() {
        player.start()
        playerState = PlayerState.PLAYING
        listener.onChange(playerState)
    }

    override fun pausePlayer() {
        player.pause()
        playerState = PlayerState.PAUSED
        listener.onChange(playerState)
    }

    override fun releasePlayer() {
        playerState = PlayerState.DEFAULT
        listener.onChange(playerState)
        player.release()
    }

    override fun getPlayerCurrentTimerPosition(): String {
        return SimpleDateFormat("mm:ss", Locale.getDefault())
            .format(player.currentPosition.toLong())
    }

    override fun getPlayerState(): PlayerState {
        return playerState
    }

    override fun setPlayerDataSource(track: Track) {
        player.setDataSource(track.previewUrl)
    }
}