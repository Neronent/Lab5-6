package com.example.animenic.model

data class Evento(
    var hora: String,
    var eventoLugar: String,
    var eventoCategoria: String,
    var eventoDireccion: String,
    var eventoLatitud: Double,
    var eventoLongitud: Double,
    var eventoTelefono: String,
    var eventoWebsite: String,
    var eventoPhoto: String
)
