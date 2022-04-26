package com.example.animenic.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.animenic.R
import com.example.animenic.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animlogo = AnimationUtils.loadAnimation(this, R.anim.anime_animation)
        val imglogo: ImageView = binding.imgLogoSplash
        imglogo.startAnimation(animlogo)

        val intent = Intent(this, LoginActivity::class.java)
        animlogo.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
    }
}