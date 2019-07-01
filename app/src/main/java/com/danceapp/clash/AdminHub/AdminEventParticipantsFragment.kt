package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.Participant
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventParticipantsBinding

class AdminEventParticipantsFragment : Fragment() {
    companion object {
        private const val TAG = "AdminEventPartFrag"
    }

    private lateinit var binding: FragmentAdminEventParticipantsBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

    private var participants: ArrayList<Participant> = ArrayList()
    private var adapter: AdminEventParticipantAdapter = AdminEventParticipantAdapter(participants)

    var onAddParticipantSaveListener: (() -> Unit)? = null
    var onSubmitParticipantListListener: (() -> Unit)? = null


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

    private fun setupViews() {
        linearLayoutManager = LinearLayoutManager(binding.root.context)
        binding.participantList.layoutManager = linearLayoutManager
        binding.participantList.adapter = adapter

        binding.addParticipant.setOnClickListener {
            onAddParticipantSaveListener?.invoke()
        }
        binding.done.setOnClickListener {
            onSubmitParticipantListListener?.invoke()
        }

    }

    fun updateParticipantListForAdapter(participant: Participant) {
        participants.add(participant)
        adapter.notifyDataSetChanged()
    }
}