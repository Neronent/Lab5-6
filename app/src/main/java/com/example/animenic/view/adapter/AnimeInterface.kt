package com.example.animenic.view.adapter

import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores

interface AnimeInterface {

    fun onAnimeClicked(anime: Anime, position: Int)
    fun onCreatorClicked(creador: Creadores, position: Int)

}