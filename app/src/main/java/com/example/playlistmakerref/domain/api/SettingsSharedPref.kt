package com.example.playlistmakerref.domain.api

interface SettingsSharedPref {
    fun getSaved(): Boolean
    fun change()
}