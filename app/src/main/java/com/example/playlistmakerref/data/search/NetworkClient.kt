package com.example.playlistmakerref.data.search

import com.example.playlistmakerref.data.search.models.NetworkResponse

interface NetworkClient {
    fun doRequest(requestModel: Any): NetworkResponse
}