package com.danceapp.clash

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FirebaseModule {
    val db = Firebase.firestore
}