package com.example.animenic.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animenic.databinding.FragmentDetailAnimeBinding
import com.example.animenic.model.Anime

class DetailAnimeFragment : Fragment() {

    private var _binding: FragmentDetailAnimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailAnimeBinding.inflate(inflater,container,false)

        var animate = arguments?.getSerializable("Anime") as Anime
        binding.tvNombreCreador.text = animate.Creador
        binding.tvFechaAnime.text = animate.fechaAnime
        binding.tvNombreAnime.text = animate.nombreAnime
        context?.let {
            Glide.with(it).load(animate.UrlAnime)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgDetalleAnime)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.ToolDetailAnime

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Anime"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

}
