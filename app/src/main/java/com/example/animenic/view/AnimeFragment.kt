package com.example.animenic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animenic.R
import com.example.animenic.databinding.FragmentAnimeBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterAnime
import com.example.animenic.view.adapter.AnimeInterface

class AnimeFragment : Fragment(), AnimeInterface {

    private lateinit var binding: FragmentAnimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeBinding.inflate(inflater,container, false)

        val recyclerAnimes = binding.rvAnime
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerAnimes.layoutManager = linearManager

        val mAdapter = AdapterAnime(getAnime(), this)

        binding.rvAnime.apply {
            setHasFixedSize(true)
            adapter = mAdapter
        }

        return binding.root
    }

    private fun getAnime(): MutableList<Anime> {
        val animeList: MutableList<Anime> = ArrayList()

        animeList.add(Anime("JoJo's Bizarre Adventure", Creador = "Hirohiko Araki", fechaAnime = "1/01/1987", UrlAnime = "https://i.blogs.es/464068/jojo-s-bizarre-adventure/840_560.jpg"))
        animeList.add(Anime("Detective Conan", Creador = "Gōshō Aoyama", fechaAnime = "19/04/1994", UrlAnime = "https://img.ecartelera.com/noticias/fotos/35600/35649/1.jpg"))
        animeList.add(Anime("Naruto", Creador = "Masashi Kishimoto", fechaAnime = "3/10/2002", UrlAnime = "https://as01.epimg.net/meristation/imagenes/2020/12/28/noticias/1609147235_045874_1647861941_noticia_normal.jpg"))
        animeList.add(Anime("Tokyo Ghoul", Creador = "Sui Ishida", fechaAnime = "29/07/2017", UrlAnime = "https://static.wikia.nocookie.net/tokyo-ghoul-la/images/5/5e/TG_S1.png/revision/latest?cb=20150224004920&path-prefix=es"))
        animeList.add(Anime("Inuyasha", Creador = "Rumiko Takahashi", fechaAnime = "16/10/2000", UrlAnime = "https://ramenparados.com/wp-content/uploads/2020/03/inuyasha.jpg"))
        animeList.add(Anime("Fullmetal Alchemist", Creador = "Hiromu Arakawa", fechaAnime = "5/04/2009", UrlAnime = "https://www.fiebreseries.com/wp-content/uploads/2021/04/Fullmetal-Alchemist-Brotherhood_poster_serie0.jpg"))
        animeList.add(Anime("Dragon Ball", Creador = "Akira Toriyama", fechaAnime = "26/02/1986", UrlAnime = "https://static1.cbrimages.com/wordpress/wp-content/uploads/2021/09/Son-Goku-Goes-On-An-Adventure-In-Dragon-Ball.jpg"))
        animeList.add(Anime("Gintama", Creador = "Hideaki Sorachi", fechaAnime = "4/04/2006", UrlAnime = "https://gcdn.lanetaneta.com/wp-content/uploads/2021/07/La-ultima-pelicula-de-Gintama-confirma-la-fecha-de-estreno.jpeg"))

        return animeList
    }

    override fun onAnimeClicked(anime: Anime, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.detailAnimeFragment)
    }
    override fun onCreatorClicked(creador: Creadores, position: Int) {}
    override fun onEventClicked(evento: Evento, position: Int) {}

}