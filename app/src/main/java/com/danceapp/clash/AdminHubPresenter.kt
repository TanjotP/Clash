package com.danceapp.clash

class AdminHubPresenter(private val view: AdminHubContract.View) : AdminHubContract.Presenter {

    override fun onGenerateKey() {
        view.showDialog("SWAG")
    }
}
