package com.example.animenic.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animenic.R
import com.example.animenic.databinding.ItemEventBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento

class AdapterEvent(private var listener: AnimeInterface) : RecyclerView.Adapter<AdapterEvent.ViewHolder>() {

    var listEventos = ArrayList<Evento>()

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEvent.ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterEvent.ViewHolder, position: Int) {
        val event = listEventos[position]

        with(holder) {
            binding.tvNombreEvento.text = event.eventoLugar
            binding.tvHoraEvento.text = event.hora

            Glide.with(mContext)
                .load(event.eventoPhoto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgFotoEvento)

            itemView.setOnClickListener{
                listener.onEventClicked(event, position)
            }

        }

    }

    override fun getItemCount(): Int = listEventos.size

    fun updateData(data:List<Evento>)
    {
        listEventos.clear()
        listEventos.addAll(data)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemEventBinding.bind(itemView)
    }

}
