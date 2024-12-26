package com.example.playlistmakerref.domain.player.api

import com.example.playlistmakerref.domain.player.PlayerInteractor
import com.example.playlistmakerref.domain.player.models.PlayerState
import com.example.playlistmakerref.domain.search.models.Track

interface PlayerRepository {

    fun preparePlayer(listener: PlayerInteractor.OnStateChangeListener)

    fun startPlayer()
    fun pausePlayer()
    fun releasePlayer()
    fun getPlayerCurrentTimerPosition(): String
    fun getPlayerState(): PlayerState
    fun setPlayerDataSource(track: Track)
}