package com.danceapp.clash

import android.support.annotation.StringRes

interface AdminHubContract {
    interface View {
        fun showDialog(message: String)
    }

    interface Presenter {
        fun onGenerateKey()
    }
}