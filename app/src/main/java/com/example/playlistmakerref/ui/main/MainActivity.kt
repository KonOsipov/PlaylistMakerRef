package com.example.playlistmakerref.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playlistmakerref.ui.mediateka.MediatekaActivity
import com.example.playlistmakerref.databinding.ActivityMainBinding
import com.example.playlistmakerref.ui.search.activity.SearchActivity
import com.example.playlistmakerref.ui.settings.activity.SettingsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val clickOnSearchButton = Intent(this, SearchActivity::class.java)
            startActivity(clickOnSearchButton)
        }

        binding.mediaButton.setOnClickListener {
            val clickOnMediatekaButton = Intent(this, MediatekaActivity::class.java)
            startActivity(clickOnMediatekaButton)
        }

        binding.settingsButton.setOnClickListener {
            val clickOnSettingsButton = Intent(this, SettingsActivity::class.java)
            startActivity(clickOnSettingsButton)
        }


    }
}