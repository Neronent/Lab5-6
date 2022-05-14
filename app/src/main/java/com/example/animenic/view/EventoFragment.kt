package com.example.animenic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animenic.R
import com.example.animenic.databinding.FragmentAnimeBinding
import com.example.animenic.databinding.FragmentEventoBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterAnime
import com.example.animenic.view.adapter.AdapterEvent
import com.example.animenic.view.adapter.AnimeInterface
import com.example.animenic.viewmodel.AnimeViewModel
import com.example.animenic.viewmodel.EventoViewModel

class EventoFragment : Fragment(), AnimeInterface {

    private var fbinding: FragmentEventoBinding? = null
    private val binding get() = fbinding!!

    private lateinit var animeAdapter: AdapterEvent
    private lateinit var viewModel:EventoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventoBinding.inflate(inflater, container, false)

        val recyclerEvento = binding.rvEvento
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerEvento.layoutManager = linearManager

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[EventoViewModel::class.java]
        viewModel.refresh()
        animeAdapter = AdapterEvent(this)

        binding.rvEvento.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = animeAdapter
        }
        observeViewModel()

        return binding.root
    }

    //Observar los datos del RecyclerView
    fun observeViewModel() {
        viewModel.listEvento.observe(viewLifecycleOwner, Observer<List<Evento>> { Evento ->
            animeAdapter.updateData(Evento)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.eventoLoading.isVisible = false
            }
        })
    }

    override fun onAnimeClicked(anime: Anime, position: Int) {}
    override fun onCreatorClicked(creador: Creadores, position: Int) {}
    override fun onEventClicked(evento: Evento, position: Int) {

        val bundle = bundleOf("Evento" to evento)

        //Cuando de click lo manda a eventoubicacion fragment
        NavHostFragment.findNavController(this).navigate(R.id.eventoUbicacionFragment, bundle)
    }

}