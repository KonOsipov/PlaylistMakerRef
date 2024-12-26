package com.example.playlistmakerref.domain.settings.impl

import com.example.playlistmakerref.domain.settings.SettingsInteractor
import com.example.playlistmakerref.domain.settings.api.SettingsRepository
import com.example.playlistmakerref.domain.settings.models.ThemeSettings

class SettingsInteractorImpl(
    private val repository: SettingsRepository
): SettingsInteractor {

    override fun getThemeSettings(): ThemeSettings {
        return repository.getThemeSettings()
    }

    override fun updateThemeSetting(settings: ThemeSettings) {
        repository.updateThemeSetting(settings)
    }
}