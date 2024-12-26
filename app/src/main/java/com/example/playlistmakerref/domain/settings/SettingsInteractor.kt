package com.example.playlistmakerref.domain.settings

import com.example.playlistmakerref.domain.settings.models.ThemeSettings

interface SettingsInteractor {
    fun getThemeSettings(): ThemeSettings
    fun updateThemeSetting(settings: ThemeSettings)
}