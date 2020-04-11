package com.danceapp.clash

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseModule {
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
    val db = Firebase.firestore
}