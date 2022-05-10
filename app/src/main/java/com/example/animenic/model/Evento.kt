package com.example.animenic.model

import java.io.Serializable

class Evento: Serializable{
    var hora: String = ""
    var EventoLugar: String = ""
    var EventoDireccion: String = ""
    var EventoLatitud: Double = 0.0
    var EventoLongitud: Double = 0.0
    var EventoTelefono: String = ""
    var EventoWebSite: String = ""
    var EventoPhoto: String = ""
}
