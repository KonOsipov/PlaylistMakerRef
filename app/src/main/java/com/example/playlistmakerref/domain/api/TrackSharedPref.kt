package com.example.playlistmakerref.domain.api

import com.example.playlistmakerref.domain.models.Track

interface TrackSharedPref {
    fun getSavedTracks(): List<Track>
    fun saveTrack(track: Track)
    fun cleanHistory()
}