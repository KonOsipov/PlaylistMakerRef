package com.example.playlistmakerref.ui.settings.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.playlistmakerref.creator.Creator
import com.example.playlistmakerref.domain.settings.SettingsInteractor
import com.example.playlistmakerref.domain.settings.models.ThemeSettings
import com.example.playlistmakerref.domain.sharing.SharingInteractor

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val sharingInteractor: SharingInteractor = Creator.provideSharingInteractor(getApplication())
    private val settingsInteractor: SettingsInteractor = Creator.provideSettingsInteractor(getApplication())

    private var themeDarkModeValueLiveData =
        MutableLiveData(getDarkModeValue())

    fun observeDarkModeValueLiveData(): LiveData<Boolean> = themeDarkModeValueLiveData

    private fun getDarkModeValue(): Boolean {
        return settingsInteractor.getThemeSettings().nightModeOn
    }

    fun updateDarkModeValue(value: Boolean) {
        settingsInteractor.updateThemeSetting(ThemeSettings(value))
        themeDarkModeValueLiveData.postValue(value)
    }


    fun shareApp() {
        sharingInteractor.shareApp()
    }

    fun openTerms() {
        sharingInteractor.openTerms()
    }

    fun openSupportEmail() {
        sharingInteractor.openSupport()
    }

    companion object {
        fun getViewModelFactory(): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SettingsViewModel(
                    application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application,
                )
            }
        }
    }

}