package com.example.animenic.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animenic.R
import com.example.animenic.databinding.FragmentEventoUbicacionDetBinding

class EventoUbicacionDetFragment : DialogFragment() {

    private lateinit var binding: FragmentEventoUbicacionDetBinding

    var direccion: String = ""
    var eventoLugar: String=""
    var website: String=""
    var tel: String = ""
    var foto: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventoUbicacionDetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = view.findViewById(R.id.toolubication)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon= ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.title = "Detalle Ubicación"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

        val objUbicacion: Bundle? = arguments
        if (objUbicacion != null) {
            eventoLugar = objUbicacion.getString("Lugar").toString()
            website = objUbicacion.getString("Website").toString()
            tel = objUbicacion.getString("Telefono").toString()
            direccion = objUbicacion.getString("Direccion").toString()
            foto = objUbicacion.getString("Foto").toString()
        }

        binding.tvEventoUbicacion.text = eventoLugar
        binding.txtDireccionEvento.text = direccion
        binding.txtTelefonoEvento.text = tel
        binding.txtSitioWebEvento.text = website

        context?.let {
            Glide.with(it)
                .load(foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgUbication)
        }

        binding.txtSitioWebEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(website)
            startActivity(intent)
        }
        binding.txtTelefonoEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${tel}")
            }
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
