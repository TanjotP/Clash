package com.danceapp.clash.AdminHub

import com.danceapp.clash.Event
import com.danceapp.clash.FirebaseModule
import com.danceapp.clash.Participant

class AdminHubPresenter(private val view: AdminHubContract.View, var database: FirebaseModule) :
    AdminHubContract.Presenter {
    private lateinit var event: Event
    private var participantList: ArrayList<Participant> = ArrayList()

    override fun onSaveEventDetails(savedEvent: Event) {
        event = savedEvent
        database.firebaseDatabase().getReference(event.eventName).setValue(event)
            .addOnSuccessListener {
                view.setupAdminEventParticipant()
            }
            .addOnFailureListener {

            }
        view.showSnackbar(event.eventName)
    }

    override fun onAddParticipant(participant: Participant) {
        participantList.add(participant)
        // preform validation
        view.updateParticipantList(participant)
    }

    override fun onSaveParticipants(savedParticipants: ArrayList<Participant>) {
        //post to firebase

    }
}
