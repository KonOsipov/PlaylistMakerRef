package com.example.playlistmakerref.domain.impl

import com.example.playlistmakerref.domain.api.PlayerInteractor
import com.example.playlistmakerref.domain.api.PlayerRepository
import com.example.playlistmakerref.domain.models.PlayerState
import com.example.playlistmakerref.domain.models.Track


class MediaPlayerInteractorImpl(
    private val playerRepository: PlayerRepository
): PlayerInteractor {
    override fun prepare(listener: PlayerInteractor.OnStateChangeListener) {
        playerRepository.preparePlayer(listener)
    }

    override fun start() {
        playerRepository.startPlayer()
    }

    override fun pause() {
        playerRepository.pausePlayer()
    }

    override fun release() {
        playerRepository.releasePlayer()
    }

    override fun getPlayerCurrentTimerPosition(): String {
        return playerRepository.getPlayerCurrentTimerPosition()
    }

    override fun getPlayerState(): PlayerState {
        return playerRepository.getPlayerState()
    }

    override fun setPlayerDataSource(track: Track) {
        playerRepository.setPlayerDataSource(track)
    }
}