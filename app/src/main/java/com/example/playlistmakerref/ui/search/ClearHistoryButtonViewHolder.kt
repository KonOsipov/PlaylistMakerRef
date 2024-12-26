package com.example.playlistmakerref.ui.search

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.playlistmakerref.databinding.ClearHistoryBtnItemBinding
import com.example.playlistmakerref.domain.search.models.Track

abstract class BaseTrackViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(model: Track)
}

class ClearHistoryButtonViewHolder(private val binding: ClearHistoryBtnItemBinding): BaseTrackViewHolder(binding.root) {

    val clearBtn: Button = binding.btnClearHistory
    override fun bind(model: Track) {}

}