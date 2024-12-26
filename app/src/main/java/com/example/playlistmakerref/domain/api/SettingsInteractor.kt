package com.example.playlistmakerref.domain.api

interface SettingsInteractor {
    fun getSaved(): Boolean
    fun change()
}