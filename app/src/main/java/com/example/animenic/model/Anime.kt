package com.example.animenic.model

data class Anime(var nombreAnime: String,
                 var UrlAnime: String,
                 var fechaAnime: String,
                 var Creador: String,
                 var isFavorite: Boolean = false)
