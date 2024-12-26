package com.example.playlistmakerref.ui.search

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.playlistmakerref.R
import com.example.playlistmakerref.databinding.TrackListItemBinding
import com.example.playlistmakerref.domain.search.models.Track
import com.example.playlistmakerref.ui.dpToPx
import java.text.SimpleDateFormat
import java.util.Locale

class TrackViewHolder(private val binding: TrackListItemBinding) : BaseTrackViewHolder(binding.root) {

    override fun bind(model: Track) {
        val cornerRadiusInPx = dpToPx(2f, itemView.context)

        binding.tvTrackName.text = model.trackName
        binding.tvTrackArtistName.text = model.artistName
        binding.tvTrackTime.text = SimpleDateFormat("mm:ss", Locale.getDefault()).format(model.trackTimeMillis)

        Glide.with(itemView)
            .load(model.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(cornerRadiusInPx))
            .into(binding.ivTrackImage)
    }

}