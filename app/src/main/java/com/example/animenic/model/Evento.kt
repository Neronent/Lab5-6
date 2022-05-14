package com.example.animenic.model

import java.io.Serializable

class Evento: Serializable{
    var hora: String = ""
    var eventoLugar: String = ""
    var eventoDireccion: String = ""
    var eventoLatitud: Double = 0.0
    var eventoLongitud: Double = 0.0
    var eventoTelefono: String = ""
    var eventoWebSite: String = ""
    var eventoPhoto: String = ""
}
