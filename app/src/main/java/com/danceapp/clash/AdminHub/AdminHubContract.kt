package com.danceapp.clash.AdminHub

import com.danceapp.clash.Event
import com.danceapp.clash.Participant

interface AdminHubContract {
    interface View {
        fun showSnackbar(message: String)

        fun setupAdminEventParticipant()

        fun updateParticipantList(participantList: Participant)

        fun setupAdminLandingPage()

    }

    interface Presenter {
        fun onSaveEventDetails(event: Event)

        fun onAddParticipant(participant: Participant)

        fun onSaveParticipants(savedParticipants: ArrayList<Participant>)
    }
}