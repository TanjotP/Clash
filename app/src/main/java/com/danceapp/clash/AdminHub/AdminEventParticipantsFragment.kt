package com.danceapp.clash.AdminHub

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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
    var onSubmitParticipantListListener: ((ArrayList<Participant>) -> Unit)? = null


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
        linearLayoutManager =
            LinearLayoutManager(binding.root.context)
        binding.participantList.layoutManager = linearLayoutManager
        binding.participantList.adapter = adapter

        val itemDecor = DividerItemDecoration(binding.root.context, HORIZONTAL)
        binding.participantList.addItemDecoration(itemDecor)
        binding.addParticipant.setOnClickListener {
            onAddParticipantSaveListener?.invoke()
        }
        binding.done.setOnClickListener {
            onSubmitParticipantListListener?.invoke(participants)
        }

    }

    fun updateParticipantListForAdapter(participant: Participant) {
        participants.add(participant)
        adapter.notifyDataSetChanged()
        //TODO: Fix updating adapter mechanism.
    }
}