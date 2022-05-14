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
import com.example.animenic.databinding.FragmentDetailCreatorBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores

class DetailCreatorFragment : Fragment() {

    private var _binding: FragmentDetailCreatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCreatorBinding.inflate(inflater,container,false)

        var creator = arguments?.getSerializable("Creador") as Creadores
        binding.tvNombre.text = creator.nombreCreador
        binding.tvFechaNac.text = creator.fechaNac
        binding.tvObrasRealizadas.text = creator.obrasRealizadas.toString()
        binding.tvBiografia.text = creator.biografiaCreador
        context?.let {
            Glide.with(it).load(creator.UrlCreador)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgDetalleCreador)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.ToolDetailCreador

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Creador"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

}