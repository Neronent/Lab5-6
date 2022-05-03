package com.example.animenic.view

import android.annotation.SuppressLint
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
import com.example.animenic.R
import com.example.animenic.databinding.FragmentEventoUbicacionDetBinding

class EventoUbicacionDetFragment : DialogFragment() {

    private lateinit var binding: FragmentEventoUbicacionDetBinding

    private var eventoLugar: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventoUbicacionDetBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
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
        }


        binding.tvEventoUbicacion.text = eventoLugar
        binding.txtDireccionEvento.text = "Axo. Villa Libertad"
        binding.txtTelefonoEvento.text = "22705128"
        binding.txtSitioWebEvento.text = "https://www.jorelojes.com"

        binding.txtSitioWebEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.jorelojes.com")
            startActivity(intent)
        }
        binding.txtTelefonoEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${22705128}")
            }
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
