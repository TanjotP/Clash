package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.Event
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventDetailsBinding
import com.danceapp.clash.databinding.FragmentAdminEventParticipantsBinding

class AdminEventParticipantsFragment : Fragment() {
    companion object {
        private const val TAG = "AdminEventPartFrag"
    }

    private lateinit var binding: FragmentAdminEventParticipantsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentAdminEventParticipantsBinding>(
            inflater,
            R.layout.fragment_admin_event_participants,
            container,
            false
        )
        setupViews()
        return binding.root
    }

    private fun setupViews(){

    }
}