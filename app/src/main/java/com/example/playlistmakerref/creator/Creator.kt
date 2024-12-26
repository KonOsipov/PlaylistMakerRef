package com.example.playlistmakerref.creator

import android.content.SharedPreferences
import com.example.playlistmakerref.data.network.MediaPlayerRepositoryImpl
import com.example.playlistmakerref.data.network.RetrofitNetworkClient
import com.example.playlistmakerref.data.network.TrackRepositoryImpl
import com.example.playlistmakerref.data.sharedPref.SettingsManager
import com.example.playlistmakerref.data.sharedPref.SettingsSharedPrefsImpl
import com.example.playlistmakerref.data.sharedPref.SharedPrefsManager
import com.example.playlistmakerref.data.sharedPref.TrackSharedPrefsImpl
import com.example.playlistmakerref.domain.api.PlayerInteractor
import com.example.playlistmakerref.domain.api.PlayerRepository
import com.example.playlistmakerref.domain.api.SettingsInteractor
import com.example.playlistmakerref.domain.api.SettingsSharedPref
import com.example.playlistmakerref.domain.api.TrackRepository
import com.example.playlistmakerref.domain.api.TrackSharedPref
import com.example.playlistmakerref.domain.api.TracksInteractor
import com.example.playlistmakerref.domain.impl.MediaPlayerInteractorImpl
import com.example.playlistmakerref.domain.impl.SettingsInteractorImpl
import com.example.playlistmakerref.domain.impl.TrackInteractorImpl

object Creator {
    private fun getTracksRepository(): TrackRepository {
        return TrackRepositoryImpl(RetrofitNetworkClient())
    }

    private fun getTrackSharedPrefs(sharedPreferences: SharedPreferences): TrackSharedPref {
        return TrackSharedPrefsImpl(SharedPrefsManager(sharedPreferences))
    }

    private fun getSettingsSharedPrefs(sharedPreferences: SharedPreferences): SettingsSharedPref {
        return SettingsSharedPrefsImpl(SettingsManager(sharedPreferences))
    }

    fun provideTracksInteractor(sharedPreferences: SharedPreferences): TracksInteractor {
        return TrackInteractorImpl(getTracksRepository(), getTrackSharedPrefs(sharedPreferences))
    }

    fun provideSettingsInteractor(sharedPreferences: SharedPreferences): SettingsInteractor {
        return SettingsInteractorImpl(getSettingsSharedPrefs(sharedPreferences))
    }

    private fun getMediaPlayerRepository(): PlayerRepository {
        return MediaPlayerRepositoryImpl()
    }

    fun provideMediaPlayaerInteractor(): PlayerInteractor {
        return MediaPlayerInteractorImpl(getMediaPlayerRepository())
    }

}