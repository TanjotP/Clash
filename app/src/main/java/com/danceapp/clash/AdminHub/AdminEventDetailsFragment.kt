package com.danceapp.clash.AdminHub

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.Event
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventDetailsBinding
import kotlinx.android.synthetic.main.title_field_generic_item.view.*

class AdminEventDetailsFragment : Fragment() {

    companion object {
        private const val TAG = "AdminEventDetailsFrag"
    }

    private lateinit var binding: FragmentAdminEventDetailsBinding
    var onSubmitEventDetailsListener: ((event: Event) -> Unit)? = null
    private lateinit var event: Event
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

    private fun setupViews() {
        setupCopy()
        binding.saveEventDetailsButton.setOnClickListener {
            populateEventData()
            onSubmitEventDetailsListener?.invoke(event)
        }
    }

    private fun populateEventData() {
        val eventCompany = binding.eventCompany.field_entry.text.toString()
        val eventName = binding.eventName.field_entry.text.toString()
        val eventKey = binding.eventKey.field_entry.text.toString()
        val eventDate = binding.eventDate.field_entry.toString()
        event = Event(eventKey, eventCompany, eventName, eventDate)
    }

    private fun setupCopy() {
        binding.eventCompany.field_title.text = R.string.set_event_company.toString()
        binding.eventName.field_title.text = R.string.set_event_name.toString()
        binding.eventKey.field_title.text = R.string.set_event_key.toString()
        binding.eventDate.field_title.text = R.string.set_event_start_date.toString()

        binding.eventCompany.field_entry.hint = R.string.set_event_company_hint.toString()
        binding.eventName.field_entry.hint = R.string.set_event_name_hint.toString()
        binding.eventKey.field_entry.hint = R.string.set_event_key_hint.toString()
        binding.eventDate.field_entry.hint = R.string.set_event_start_date_hint.toString()

    }
}