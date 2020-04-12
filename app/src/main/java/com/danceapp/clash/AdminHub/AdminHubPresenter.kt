package com.danceapp.clash.AdminHub

import android.util.Log
import com.danceapp.clash.Event
import com.danceapp.clash.FirebaseModule
import com.danceapp.clash.Participant

const val TAG = "AdminHubPresenter"
const val PARTICIPANTS = "participants"
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
        //TODO: Verify that the db does not have an event that that is the same... if it does, make user choose different event key.
        //cannot overwrite an event key.
        database.db.collection("events").document(event.eventKey)
            .set(event)
            .addOnSuccessListener {
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
        savedParticipants.forEach {
            database.db.collection("events").document(event.eventKey).collection(PARTICIPANTS).document(it.teamName)
                .set(it)
                .addOnSuccessListener {
                    view.showSnackbar("Event participants have been saved.")
                    view.setupAdminLandingPage()
                }
        }

    }
}
