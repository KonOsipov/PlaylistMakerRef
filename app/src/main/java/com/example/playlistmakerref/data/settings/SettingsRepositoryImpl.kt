package com.example.playlistmakerref.data.settings

import android.content.Context
import com.example.playlistmakerref.domain.settings.api.SettingsRepository
import com.example.playlistmakerref.domain.settings.models.ThemeSettings

class SettingsRepositoryImpl(context: Context): SettingsRepository {

    private val settingsSharedPrefs =
        context.getSharedPreferences(SettingsRepository.SETTINGS_STORAGE, Context.MODE_PRIVATE)

    override fun getThemeSettings(): ThemeSettings {
        return ThemeSettings(settingsSharedPrefs.getBoolean(SettingsRepository.NIGHT_MODE_KEY,false))
    }

    override fun updateThemeSetting(settings: ThemeSettings) {
        settingsSharedPrefs.edit()
            .putBoolean(SettingsRepository.NIGHT_MODE_KEY, settings.nightModeOn)
            .apply()
    }

}