package com.example.animenic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.animenic.R
import com.example.animenic.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuAnimenic: BottomNavigationView = binding.bottomNavMenu
        setupWithNavController(menuAnimenic, findNavController(this, R.id.frag_navgraph))
    }

}