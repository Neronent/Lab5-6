package com.example.animenic.network

import com.example.animenic.model.Anime
import com.example.animenic.model.Creadores
import com.example.animenic.model.Evento
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings


//Las colecciones deben tener el mismo nombre físico de las colecciones
//en el servidor Cloud Firestore
const val ARTISTA_COLLECTION_NAME="Creador"
const val EVENTO_COLLECTION_NAME="Evento"
const val GALERIA_COLLECTION_NAME="Anime"


class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        //Nos permite tener los datos offline
        firebaseFirestore.firestoreSettings=settings
    }

    //El Callback corresponde a la interfaz creada por nosotros mismos
    fun getArtistas(callback: Callback <List<Creadores>>) {
        firebaseFirestore.collection(ARTISTA_COLLECTION_NAME)
            .orderBy("nombreCreador")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(Creadores::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getEventos(callback:Callback <List<Evento>>) {
        firebaseFirestore.collection(EVENTO_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(Evento::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getgaleria(callback:Callback <List<Anime>>) {
        firebaseFirestore.collection(GALERIA_COLLECTION_NAME)
            .orderBy("nombreAnime")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(Anime::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}