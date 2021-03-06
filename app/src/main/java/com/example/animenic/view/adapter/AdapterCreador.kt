package com.example.animenic.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animenic.R
import com.example.animenic.databinding.ItemCreadoresBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores

class AdapterCreador(private var listener: AnimeInterface) : RecyclerView.Adapter<AdapterCreador.ViewHolder>() {

    var listCreadores = ArrayList<Creadores>()

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCreador.ViewHolder {

        mContext = parent.context

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_creadores, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val creator = listCreadores[position]

        with(holder){
            binding.tvNombreCreador.text = creator.nombreCreador

            Glide.with(mContext)
                .load(creator.UrlCreador)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgFotoAnime)

            binding.imgFotoAnime.setOnClickListener{ listener.onCreatorClicked(creator, position) }

        }
    }

    override fun getItemCount(): Int = listCreadores.size

    fun updateData(data:List<Creadores>)
    {
        listCreadores.clear()
        listCreadores.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemCreadoresBinding.bind(itemView)
    }

}
