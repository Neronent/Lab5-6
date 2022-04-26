package com.example.animenic.model

data class Creadores(var nombreCreador: String,
                     var fechaNac: String,
                     var obrasRealizadas: Int,
                     var UrlCreador: String,
                     var isFavorite: Boolean = false)
