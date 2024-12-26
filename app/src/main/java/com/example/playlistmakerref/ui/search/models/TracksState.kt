package com.example.playlistmakerref.ui.search.models

import com.example.playlistmakerref.domain.search.models.Track

sealed interface TracksState {

    object Loading: TracksState
    //data object Loading: TracksState

    data class  Content(
        val tracks: List<Track>
    ): TracksState

    data class  History(
        val historyTracks: List<Track>
    ): TracksState

    data class Error(
        val errorMessage: String
    ):TracksState

    data class Empty(
        val emptyMessage: String
    ):TracksState
}