package com.example.playlistmakerref.domain.api

import com.example.playlistmakerref.domain.models.Track

interface TracksInteractor {
    fun searchTracks(expression: String, consumer: TracksConsumer)
    fun getSavedTracks(): List<Track>
    fun saveTrack(track: Track)
    fun cleanHistory()

    interface TracksConsumer {
        fun consume(foundTracks: List<Track>, resultCode: Int)
        fun onFailure(t: Throwable)
    }
}