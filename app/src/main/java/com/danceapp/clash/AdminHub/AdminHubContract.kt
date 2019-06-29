package com.danceapp.clash.AdminHub

import android.support.annotation.StringRes
import com.danceapp.clash.Event

interface AdminHubContract {
    interface View {
        fun showDialog(message: String)
    }

    interface Presenter {
        fun onSaveDetails(event : Event)
    }
}