package com.example.animenic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animenic.R
import com.example.animenic.databinding.FragmentEventoBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterEvent
import com.example.animenic.view.adapter.AnimeInterface

class EventoFragment : Fragment(), AnimeInterface {

    private lateinit var binding: FragmentEventoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventoBinding.inflate(inflater, container, false)

        val recyclerEvento = binding.rvEvento
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerEvento.layoutManager = linearManager

        val mAdapter = AdapterEvent(getEvent(), this)

        binding.rvEvento.apply {
            setHasFixedSize(true)
            adapter = mAdapter
        }


        return binding.root
    }

    private fun getEvent(): MutableList<Evento> {
        val eventoList: MutableList<Evento> = ArrayList()

        eventoList.add(Evento("9:00", "Multicentro", "Ventas", "De la racatanga 3 cuadras al sur", 12.139659938541937, -86.22934029197263,  "12345678", "https://www.multicentro.com", "https://upload.wikimedia.org/wikipedia/commons/0/0b/Multicentro_Las_Americas.jpg"))
        eventoList.add(Evento("7:00", "Metrocentro", "Cosplay", "De la chingada 3 cuadras al sur", 12.127940710896864, -86.26473651560194, "87654321", "https://www.metrocentro.com", "https://img.lanicaraguadehoy.com/lanicaraguadehoy/59d1f062-navidad-1200x675.jpeg"))
        eventoList.add(Evento("12:00", "Parque Japones", "todo publico", "De la chingada 3 cuadras al sur y 4 cuadras al norte", 12.125245681175514, -86.26071307327294, "85246317", "https://www.parquejapones.com", "https://upload.wikimedia.org/wikipedia/commons/8/8d/Parque_japones_de_Managua.jpg"))
        eventoList.add(Evento("10:00", "Hotel HEXX", "Casual", "De la chimichanga 3 cuadras al sur", 12.140848968883114, -86.22902283094388, "56784231", "https://www.hotelhexx.com", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/228288654.jpg?k=5f465884048c2329e151ab8d340ef3665b5cf1f146ce05bec8273922ba61b12f&o=&hp=1"))
        eventoList.add(Evento("11:00", "Academia de danza", "Cosplay", "Frente a la chingadera uni de kk", 12.12834103189141, -86.27060714443743, "45623187", "https://www.academiadedanza.com", "https://nuevaya.com.ni/wp-content/uploads/2016/11/Academia-Nicaragu%CC%88ense-de-la-Danza.jpeg"))

        return eventoList
    }

    override fun onAnimeClicked(anime: Anime, position: Int) {}
    override fun onCreatorClicked(creador: Creadores, position: Int) {}
    override fun onEventClicked(evento: Evento, position: Int) {

        //Pasar los parametros al ubicacion fragment
        //Declaracion de variables
        val bundle = Bundle()
        bundle.putDouble("Latitud", evento.eventoLatitud)
        bundle.putDouble("Longitud", evento.eventoLongitud)
        bundle.putString("Lugar", evento.eventoLugar)
        bundle.putString("Direccion", evento.eventoDireccion)
        bundle.putString("Telefono", evento.eventoTelefono)
        bundle.putString("Website", evento.eventoWebsite)
        bundle.putString("FotoWeb", evento.eventoPhoto)

        //Cuando de click lo manda a eventoubicacion fragment
        NavHostFragment.findNavController(this).navigate(R.id.eventoUbicacionFragment, bundle)
    }

}