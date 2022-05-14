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
import com.example.animenic.databinding.FragmentCreadorBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterCreador
import com.example.animenic.view.adapter.AnimeInterface
import com.example.animenic.viewmodel.CreadorViewModel

class CreadorFragment : Fragment(), AnimeInterface {

    private var fbinding: FragmentCreadorBinding? = null
    private val binding get() = fbinding!!

    private lateinit var creadorAdapter: AdapterCreador
    private lateinit var viewModel:CreadorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentCreadorBinding.inflate(inflater,container, false)

        val recyclerAnimes = binding.rvCreador
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerAnimes.layoutManager = linearManager

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[CreadorViewModel::class.java]
        viewModel.refresh()
        creadorAdapter = AdapterCreador(this)

        binding.rvCreador.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = creadorAdapter
        }
        observeViewModel()

        return binding.root
    }

    fun observeViewModel() {
        viewModel.listCreadores.observe(viewLifecycleOwner, Observer<List<Creadores>> { Creadores ->
            creadorAdapter.updateData(Creadores)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.creadorLoading.isVisible = false
            }
        })
    }

    override fun onAnimeClicked(anime: Anime, position: Int) {}

    override fun onCreatorClicked(creador: Creadores, position: Int) {
        val bundle = bundleOf("Creador" to creador)
        NavHostFragment.findNavController(this).navigate(R.id.detailCreatorFragment, bundle)
    }

    override fun onEventClicked(evento: Evento, position: Int) {}

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}