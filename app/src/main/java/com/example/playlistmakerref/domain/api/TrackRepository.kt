package com.example.playlistmakerref.domain.api

import com.example.playlistmakerref.domain.models.Track

interface TrackRepository {
    fun searchTracks(expression: String): List<Track>

    fun getResultCode(): Int
}