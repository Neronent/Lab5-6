package com.example.animenic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animenic.model.Creadores
import com.example.animenic.network.Callback
import com.example.animenic.network.FirestoreService

class CreadorViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listCreadores: MutableLiveData<List<Creadores>> = MutableLiveData()
    var isLoading= MutableLiveData<Boolean>()

    fun refresh() {
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getArtistas(object : Callback<List<Creadores>> {
            override fun onSuccess(result:List<Creadores>?){
                listCreadores.postValue(result)
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