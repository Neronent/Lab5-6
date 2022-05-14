package com.example.animenic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animenic.model.Evento
import com.example.animenic.network.Callback
import com.example.animenic.network.FirestoreService

class EventoViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listEvento: MutableLiveData<List<Evento>> = MutableLiveData()
    var isLoading= MutableLiveData<Boolean>()

    fun refresh() {
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getEventos(object : Callback<List<Evento>> {
            override fun onSuccess(result:List<Evento>?){
                listEvento.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception){
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }

}