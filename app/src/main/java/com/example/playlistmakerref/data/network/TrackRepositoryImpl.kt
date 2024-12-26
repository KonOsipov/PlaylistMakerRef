package com.example.playlistmakerref.data.network

import com.example.playlistmakerref.data.NetworkClient
import com.example.playlistmakerref.data.dto.TrackResponse
import com.example.playlistmakerref.data.dto.TrackSearchRequest
import com.example.playlistmakerref.domain.api.TrackRepository
import com.example.playlistmakerref.domain.models.Track

class TrackRepositoryImpl (private val networkClient: NetworkClient) : TrackRepository {

    private var resultCode = 0

    override fun searchTracks(expression: String): List<Track> {
        val response = networkClient.doRequest(TrackSearchRequest(expression))
        resultCode = response.resultCode
        if (response.resultCode == 200) {
            return (response as TrackResponse).results.map {
                Track(
                    it.trackName,
                    it.artistName,
                    it.trackTimeMillis,
                    it.artworkUrl100,
                    it.trackId,
                    it.collectionName,
                    it.releaseDate,
                    it.primaryGenreName,
                    it.country,
                    it.previewUrl
                ) }
        } else {
            return emptyList()
        }
    }

    override fun getResultCode(): Int {
        return resultCode
    }


}