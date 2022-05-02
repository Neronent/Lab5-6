package com.example.animenic.view.adapter

import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento

interface AnimeInterface {

    fun onAnimeClicked(anime: Anime, position: Int)
    fun onCreatorClicked(creador: Creadores, position: Int)
    fun onEventClicked(evento: Evento, position: Int)

}