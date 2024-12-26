package com.example.playlistmakerref.data

import com.example.playlistmakerref.data.dto.SharedPrefsHistory

interface SavedTracksClient {
    fun getSaved(): SharedPrefsHistory
    fun save(dto: Any)
    fun clean()
}