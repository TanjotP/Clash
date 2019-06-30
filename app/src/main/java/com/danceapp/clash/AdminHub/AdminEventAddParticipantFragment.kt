package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventAddParticipantBinding
import com.danceapp.clash.databinding.FragmentAdminEventParticipantsBinding

class AdminEventAddParticipantFragment : Fragment(){
    companion object {
        private const val TAG = "AdminEventAddPart"
    }

    private lateinit var binding: FragmentAdminEventAddParticipantBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentAdminEventAddParticipantBinding>(
            inflater,
            R.layout.fragment_admin_event_add_participant,
            container,
            false
        )
        setupViews()
        return binding.root
    }

    private fun setupViews(){

    }
}