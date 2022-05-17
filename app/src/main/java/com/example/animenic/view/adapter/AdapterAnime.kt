package com.example.animenic.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animenic.R
import com.example.animenic.databinding.ItemAnimesBinding
import com.example.animenic.model.Anime

class AdapterAnime (private var listener: AnimeInterface) : RecyclerView.Adapter<AdapterAnime.ViewHolder>() {

    var listAnime = ArrayList<Anime>()

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = listAnime[position]

        with(holder){
            binding.tvNombreAnime.text = anime.nombreAnime

            Glide.with(mContext)
                .load(anime.UrlAnime)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgFotoAnime)

            binding.imgFotoAnime.setOnClickListener{ listener.onAnimeClicked(anime, position) }

        }

    }

    override fun getItemCount(): Int = listAnime.size

    fun updateData(data:List<Anime>)
    {
        listAnime.clear()
        listAnime.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemAnimesBinding.bind(itemView)
    }

}