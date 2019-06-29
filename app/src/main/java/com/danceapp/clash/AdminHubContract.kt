package com.danceapp.clash

interface AdminHubContract {
    interface View {
        fun showDialog()
    }

    interface  Presenter {
        fun onGenerateKey()
    }
}