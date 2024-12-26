package com.example.playlistmakerref.data.sharedPref

import com.example.playlistmakerref.domain.api.SettingsSharedPref

class SettingsSharedPrefsImpl(private val settingsManager: SettingsManager) : SettingsSharedPref {
    override fun getSaved(): Boolean {
        return settingsManager.getSaved().savedTheme
    }

    override fun change() {
        settingsManager.change()
    }
}