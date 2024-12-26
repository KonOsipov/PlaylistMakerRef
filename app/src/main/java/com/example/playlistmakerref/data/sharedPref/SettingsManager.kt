package com.example.playlistmakerref.data.sharedPref

import android.content.SharedPreferences
import com.example.playlistmakerref.data.SavedSettingsClient
import com.example.playlistmakerref.data.dto.SharedPrefsSettings

class SettingsManager(val sharedPreferences: SharedPreferences) : SavedSettingsClient {

    override fun getSaved(): SharedPrefsSettings {
        return SharedPrefsSettings(sharedPreferences.getBoolean(THEME_KEY, false))
    }

    override fun change() {
        val savedTheme = getSaved()
        sharedPreferences.edit()
            .putBoolean(THEME_KEY, !(savedTheme.savedTheme))
            .apply()
    }

    private companion object {
        const val THEME_KEY = "key"
    }

}