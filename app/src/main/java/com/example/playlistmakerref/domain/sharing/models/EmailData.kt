package com.example.playlistmakerref.domain.sharing.models

data class EmailData(
    val emailAddress: String,
    val messageTopic: String,
    val message: String,
)