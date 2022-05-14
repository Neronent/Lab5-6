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
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterAnime
import com.example.animenic.view.adapter.AnimeInterface
import com.example.animenic.viewmodel.AnimeViewModel

class AnimeFragment : Fragment(), AnimeInterface {

    private var fbinding:FragmentAnimeBinding? = null
    private val binding get() = fbinding!!


    private lateinit var animeAdapter: AdapterAnime
    private lateinit var viewModel:AnimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentAnimeBinding.inflate(inflater,container, false)

        val recyclerAnimes = binding.rvAnime
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerAnimes.layoutManager = linearManager

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AnimeViewModel::class.java]
        viewModel.refresh()
        animeAdapter = AdapterAnime(this)

        binding.rvAnime.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = animeAdapter
        }
        observeViewModel()

        return binding.root
    }

    //Observar los datos del RecyclerView
    fun observeViewModel() {
        viewModel.listGaleria.observe(viewLifecycleOwner, Observer<List<Anime>> { Anime ->
            animeAdapter.updateData(Anime)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.animeLoading.isVisible = false
            }
        })

    }


    override fun onAnimeClicked(anime: Anime, position: Int) {
        val bundle = bundleOf("Anime" to anime)

        NavHostFragment.findNavController(this).navigate(R.id.detailAnimeFragment, bundle)
    }
    override fun onCreatorClicked(creador: Creadores, position: Int) {}
    override fun onEventClicked(evento: Evento, position: Int) {}

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }


}