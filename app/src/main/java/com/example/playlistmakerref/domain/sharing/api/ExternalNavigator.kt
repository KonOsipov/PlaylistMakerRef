package com.example.playlistmakerref.domain.sharing.api

import com.example.playlistmakerref.domain.sharing.models.EmailData

interface ExternalNavigator {

    fun shareLink(shareLink: String)

    fun openLink(termsLink: String)

    fun openEmail(email: EmailData)
}