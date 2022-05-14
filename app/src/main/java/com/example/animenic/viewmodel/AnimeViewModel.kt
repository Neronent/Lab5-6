package com.example.animenic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animenic.model.Anime
import com.example.animenic.network.Callback
import com.example.animenic.network.FirestoreService

class AnimeViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listGaleria: MutableLiveData<List<Anime>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getgaleria(object: Callback<List<Anime>> {
            override fun onSuccess(result: List<Anime>?) {
                listGaleria.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }

}