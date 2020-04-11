package com.danceapp.clash.AdminHub

import android.util.Log
import com.danceapp.clash.Event
import com.danceapp.clash.FirebaseModule
import com.danceapp.clash.Participant

const val TAG = "AdminHubPresenter"

class AdminHubPresenter(private val view: AdminHubContract.View, var database: FirebaseModule) :
    AdminHubContract.Presenter {
    private lateinit var event: Event
    private var participantList: ArrayList<Participant> = ArrayList()

    override fun onSaveEventDetails(event: Event) {
        if (event.eventKey.isEmpty() || event.eventName.isEmpty() || event.eventCompany.isEmpty()) {
            view.showSnackbar("Cannot submit empty fields")
            return
        }

        this.event = event
        database.db.collection("Events").document(event.eventKey)
            .set(this.event)
            .addOnSuccessListener {
                Log.d(TAG, "DocumentSnapshot successfully written!")
                view.showSnackbar("Event details have been saved.")
                view.setupAdminEventParticipant()
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    override fun onAddParticipant(participant: Participant) {
        participantList.add(participant)


        view.updateParticipantList(participant)
    }

    override fun onSaveParticipants(savedParticipants: ArrayList<Participant>) {
        view.showSnackbar("Event details have been saved.")
    }
}
