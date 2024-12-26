package com.example.playlistmakerref.domain.player

import com.example.playlistmakerref.domain.player.models.PlayerState
import com.example.playlistmakerref.domain.search.models.Track

interface PlayerInteractor {
    fun prepare(listener: OnStateChangeListener)
    fun start()
    fun pause()
    fun release()
    fun getPlayerCurrentTimerPosition(): String
    fun getPlayerState(): PlayerState
    fun setPlayerDataSource(track: Track)

    interface OnStateChangeListener {
        fun onChange()
    }
}