package com.example.animenic.view

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.animenic.R
import com.example.animenic.databinding.FragmentEventoUbicacionBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class EventoUbicacionFragment : DialogFragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    var latitud: Double = 0.0
    var longitud: Double = 0.0
    var eventoLugar: String = ""

    private lateinit var binding: FragmentEventoUbicacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventoUbicacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val objUbicacion: Bundle? = arguments
        if(objUbicacion != null) {
            latitud = objUbicacion.getDouble("Latitud")
            longitud = objUbicacion.getDouble("Longitud")
            eventoLugar = objUbicacion.getString("Lugar").toString()
        }

        val toolbar: Toolbar = view.findViewById(R.id.toolDetailEvent)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Ubicacion"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

        //Agregar el marcador en el mapa
        //Informacion de ubicacion
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        //Declaracion de variables
        val zoom = 16f
        val centerMap = LatLng(latitud, longitud)

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))
        val centerMark = LatLng(latitud, longitud)
        val markerOptions = MarkerOptions()
        markerOptions.position(centerMark)
        markerOptions.title(eventoLugar)

        val bitmapDraw = context?.applicationContext?.let{ ContextCompat.getDrawable(it, R.drawable.ic_location) } as BitmapDrawable
        val smallMarker = Bitmap.createScaledBitmap(bitmapDraw.bitmap,150,150,false)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        googleMap.addMarker(markerOptions)
        googleMap.setOnMarkerClickListener(this)

        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style))

    }

    override fun onMarkerClick(googleMap: Marker): Boolean {
        val bundle = Bundle()
        bundle.putString("Lugar",eventoLugar)
        NavHostFragment.findNavController(this).navigate(R.id.eventoUbicacionDetFragment, bundle)
        return true
    }

}