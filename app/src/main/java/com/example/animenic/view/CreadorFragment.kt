package com.example.animenic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animenic.R
import com.example.animenic.databinding.FragmentCreadorBinding
import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.example.animenic.view.adapter.AdapterCreador
import com.example.animenic.view.adapter.AnimeInterface

class CreadorFragment : Fragment(), AnimeInterface {

    private lateinit var binding: FragmentCreadorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreadorBinding.inflate(inflater,container, false)

        val recyclerCreador = binding.rvCreador
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerCreador.layoutManager = linearManager

//        val mAdapter = AdapterCreador(getCreador(), this)
//
//        binding.rvCreador.apply {
//            setHasFixedSize(true)
//            adapter = mAdapter
//        }

        return binding.root
    }

//    private fun getCreador(): MutableList<Creadores> {
//        val creadorList: MutableList<Creadores> = ArrayList()
//
//        creadorList.add(Creadores("Hirohiko Araki", "7/06/1960", 12, "https://img1.ak.crunchyroll.com/i/spire3/1c28b6c6f6d365a19717e9b063aabbd51623075455_main.jpg"))
//        creadorList.add(Creadores("Gōshō Aoyama", "21/06/1963", 7, "https://static.wikia.nocookie.net/manga/images/2/24/450px-Gosho_Aoyama.jpg/revision/latest?cb=20110507153801&path-prefix=es"))
//        creadorList.add(Creadores("Masashi Kishimoto", "8/11/1974", 7, "https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_960,h_500/https://www.otakulegion.com/wp-content/uploads/2020/12/masashi-kishimoto-1.jpg"))
//        creadorList.add(Creadores("Sui Ishida", "28/12/1986", 5, "https://areajugones.sport.es/wp-content/uploads/2021/04/imagen-2021-04-09-112458.jpg"))
//        creadorList.add(Creadores("Rumiko Takahashi", "10/10/1957", 6, "https://images.mubicdn.net/images/cast_member/40868/cache-343864-1528104313/image-w856.jpg?size=800x"))
//        creadorList.add(Creadores("Hiromu Arakawa", "8/05/1973", 9, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2021/07/hiromu-arakawa-autora-manga-fullmetal-alchemist-2400547.jpg?itok=Ta9BJbBP"))
//        creadorList.add(Creadores("Akira Toriyama", "5/04/1955", 49, "https://www.fayerwayer.com/resizer/YJKMk9tiWpDGjLzo6HIIQ65_RqA=/1440x1080/filters:format(jpg):quality(70)/cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/MDZSQIMVFJGV3FLPE5CXJGMDTY.jpg"))
//        creadorList.add(Creadores("Hideaki Sorachi", "25/05/1979", 6, "https://cdn.myanimelist.net/images/voiceactors/1/44890.jpg"))
//
//        return creadorList
//    }

    override fun onAnimeClicked(anime: Anime, position: Int) {}

    override fun onCreatorClicked(creador: Creadores, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.detailCreatorFragment)
    }

    override fun onEventClicked(evento: Evento, position: Int) {}

}