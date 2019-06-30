package com.danceapp.clash

import com.google.firebase.database.FirebaseDatabase

class FirebaseModule {
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
}