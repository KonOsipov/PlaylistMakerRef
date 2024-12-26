package com.example.playlistmakerref.data.search

import com.example.playlistmakerref.data.search.models.TrackDto
import com.example.playlistmakerref.data.search.models.TracksSearchResponse
import com.example.playlistmakerref.data.search.models.TracksSearchRequest
import com.example.playlistmakerref.domain.search.api.TracksRepository
import com.example.playlistmakerref.domain.search.models.Resource
import com.example.playlistmakerref.domain.search.models.Track

class TracksRepositoryImpl(
    private val networkClient: NetworkClient,
    private val tracksStorage: TracksStorage,
): TracksRepository {

    override fun searchTracks(expression: String): Resource<List<Track>> {
        val response = networkClient.doRequest(TracksSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error(Resource.CHECK_CONNECTION)
            }
            200 -> {
                Resource.Success((response as TracksSearchResponse).results.map {
                    TrackDto.convertToTrack(it)
                })
            }
            else -> {
                Resource.Error(Resource.SERVER_ERROR)
            }
        }
    }

    override fun saveHistory(historyList: List<Track>) {
        val trackHistoryList = historyList.map { TrackDto.trackToTrackDto(it) }
        tracksStorage.saveHistory(trackHistoryList)
    }

    override fun getHistory(): ArrayList<Track>? {
        return tracksStorage.getHistory()?.map { TrackDto.convertToTrack(it) } as ArrayList<Track>?
    }

    override fun cleanHistory() {
        tracksStorage.cleanHistory()
    }

}