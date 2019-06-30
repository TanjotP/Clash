package com.danceapp.clash.AdminHub

import com.danceapp.clash.Event
import com.danceapp.clash.FirebaseModule

class AdminHubPresenter(private val view: AdminHubContract.View, var database: FirebaseModule) :
    AdminHubContract.Presenter {

    override fun onSaveDetails(event: Event) {
        database.firebaseDatabase().getReference("Admin").setValue(event.eventName)
        view.showDialog(event.eventName)
    }
}
