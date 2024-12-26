package com.example.playlistmakerref.creator

import android.content.Context
import com.example.playlistmakerref.data.player.MediaPlayerRepositoryImpl
import com.example.playlistmakerref.data.search.TracksRepositoryImpl
import com.example.playlistmakerref.data.search.network.RetrofitNetworkClient
import com.example.playlistmakerref.data.search.storage.SharedPrefsTracksStorage
import com.example.playlistmakerref.data.settings.SettingsRepositoryImpl
import com.example.playlistmakerref.data.sharing.ExternalNavigatorImlp
import com.example.playlistmakerref.domain.player.PlayerInteractor
import com.example.playlistmakerref.domain.player.api.PlayerRepository
import com.example.playlistmakerref.domain.player.impl.MediaPlayerInteractorImpl
import com.example.playlistmakerref.domain.search.TracksInteractor
import com.example.playlistmakerref.domain.search.api.TracksRepository
import com.example.playlistmakerref.domain.search.imp.TracksInteractorImpl
import com.example.playlistmakerref.domain.settings.SettingsInteractor
import com.example.playlistmakerref.domain.settings.api.SettingsRepository
import com.example.playlistmakerref.domain.settings.impl.SettingsInteractorImpl
import com.example.playlistmakerref.domain.sharing.SharingInteractor
import com.example.playlistmakerref.domain.sharing.api.ExternalNavigator
import com.example.playlistmakerref.domain.sharing.impl.SharingInteractorImpl

object Creator {

    fun provideSharingInteractor(context: Context): SharingInteractor {
        return SharingInteractorImpl(context, getExternalNavigator(context))
    }

    private fun getExternalNavigator(context: Context): ExternalNavigator {
        return ExternalNavigatorImlp(context)
    }

    fun provideSettingsInteractor(context: Context): SettingsInteractor {
        return SettingsInteractorImpl(getSettingsRepository(context))
    }

    private fun getSettingsRepository(context: Context): SettingsRepository {
        return SettingsRepositoryImpl(context)
    }

    fun provideTracksInteractor(context: Context): TracksInteractor {
        return TracksInteractorImpl(getTracksRepository(context))
    }

    private fun getTracksRepository(context: Context): TracksRepository {
        return TracksRepositoryImpl(
            networkClient = RetrofitNetworkClient(context),
            tracksStorage = SharedPrefsTracksStorage(context)
        )
    }

    fun provideMediaPlayerInteractor(): PlayerInteractor {
        return MediaPlayerInteractorImpl(getMediaPlayerRepository())
    }

    private fun getMediaPlayerRepository(): PlayerRepository {
        return MediaPlayerRepositoryImpl()
    }

}