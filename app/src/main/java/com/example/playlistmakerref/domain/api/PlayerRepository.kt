package com.example.playlistmakerref.domain.api

import com.example.playlistmakerref.domain.models.PlayerState
import com.example.playlistmakerref.domain.models.Track

interface PlayerRepository {
    fun preparePlayer(listener: PlayerInteractor.OnStateChangeListener)
    fun startPlayer()
    fun pausePlayer()
    fun releasePlayer()
    fun getPlayerCurrentTimerPosition(): String
    fun getPlayerState(): PlayerState
    fun setPlayerDataSource(track: Track)
}