package com.danceapp.clash.AdminHub

import com.danceapp.clash.Event

class AdminHubPresenter(private val view: AdminHubContract.View) :
    AdminHubContract.Presenter {

    override fun onSaveDetails(event: Event) {

        view.showDialog(event.eventName)

    }
}
