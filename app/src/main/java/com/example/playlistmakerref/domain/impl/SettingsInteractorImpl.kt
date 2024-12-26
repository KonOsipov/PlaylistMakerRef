package com.example.playlistmakerref.domain.impl

import com.example.playlistmakerref.domain.api.SettingsInteractor
import com.example.playlistmakerref.domain.api.SettingsSharedPref

class SettingsInteractorImpl(private val sharedPrefs: SettingsSharedPref) : SettingsInteractor {
    override fun getSaved(): Boolean {
        return sharedPrefs.getSaved()
    }

    override fun change() {
        sharedPrefs.change()
    }

}