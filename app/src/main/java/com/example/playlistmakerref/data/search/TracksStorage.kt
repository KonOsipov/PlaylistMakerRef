package com.example.playlistmakerref.data.search

import com.example.playlistmakerref.data.search.models.TrackDto

interface TracksStorage {

    fun saveHistory(historyList: List<TrackDto>)

    fun getHistory(): ArrayList<TrackDto>?

    fun cleanHistory()
}