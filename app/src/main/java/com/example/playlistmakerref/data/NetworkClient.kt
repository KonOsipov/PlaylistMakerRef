package com.example.playlistmakerref.data

import com.example.playlistmakerref.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response

}