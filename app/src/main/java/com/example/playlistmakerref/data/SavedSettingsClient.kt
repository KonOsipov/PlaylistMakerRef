package com.example.playlistmakerref.data

import com.example.playlistmakerref.data.dto.SharedPrefsSettings

interface SavedSettingsClient {
    fun getSaved(): SharedPrefsSettings
    fun change()

}