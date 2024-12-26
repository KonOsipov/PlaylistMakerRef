package com.example.playlistmakerref.data.dto
class TrackResponse(
    val results: List<TrackDto>, resultCode: Int
) : Response(resultCode)