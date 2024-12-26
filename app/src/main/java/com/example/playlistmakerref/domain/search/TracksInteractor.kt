package com.example.playlistmakerref.domain.search

import com.example.playlistmakerref.domain.search.models.Track

interface TracksInteractor {

    fun searchTracks(expression: String, consumer: TracksConsumer)

    fun getTrackListHistory(): ArrayList<Track>?

    fun putTrackToHistoryList(track: Track)

    fun cleanTrackListHistory()

    interface TracksConsumer {
        fun consume(foundTracks: List<Track>?, message: String?)
    }
}