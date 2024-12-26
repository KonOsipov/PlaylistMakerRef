package com.example.playlistmakerref.domain.search.api

import com.example.playlistmakerref.domain.search.models.Resource
import com.example.playlistmakerref.domain.search.models.Track

interface TracksRepository {

    fun searchTracks(expression: String): Resource<List<Track>>

    fun saveHistory(historyList: List<Track>)

    fun getHistory(): ArrayList<Track>?

    fun cleanHistory()
}