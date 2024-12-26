package com.example.playlistmakerref.domain.api

import com.example.playlistmakerref.domain.models.PlayerState
import com.example.playlistmakerref.domain.models.Track

interface PlayerInteractor {
    fun prepare(listener: OnStateChangeListener)
    fun start()
    fun pause()
    fun release()
    fun getPlayerCurrentTimerPosition(): String
    fun getPlayerState(): PlayerState
    fun setPlayerDataSource(track: Track)

    interface OnStateChangeListener {
        fun onChange(state: PlayerState)
    }
}