package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.Event
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventDetailsBinding

class AdminEventDetailsFragment : Fragment() {

    companion object {
        private const val TAG = "AdminEventDetailsFrag"
    }

    private lateinit var binding: FragmentAdminEventDetailsBinding
    var onSubmitEventDetailsListener: ((event: Event) -> Unit)? = null
    private lateinit var event : Event
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentAdminEventDetailsBinding>(
            inflater,
            R.layout.fragment_admin_event_details,
            container,
            false
        )
        setupViews()
        return binding.root
    }

    fun setupViews() {
        binding.saveEventDetailsButton.setOnClickListener {
            populateEventData()
            onSubmitEventDetailsListener?.invoke(event)
        }
    }

    private fun populateEventData() {
        var eventName = binding.eventName.text.toString()
        var eventDate = binding.eventDate.text.toString()

        event = Event(eventName, eventDate)
    }
}