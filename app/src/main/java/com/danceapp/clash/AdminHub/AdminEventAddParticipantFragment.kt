package com.danceapp.clash.AdminHub

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.Participant
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventAddParticipantBinding

class AdminEventAddParticipantFragment : BottomSheetDialogFragment() {
    companion object {
        private const val TAG = "AdminEventAddPart"
    }

    private lateinit var binding: FragmentAdminEventAddParticipantBinding
    var onAddParticipantListener: ((participant: Participant) -> Unit)? = null

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

    private fun setupViews() {
        var participantName: String
        var participantDesc: String
        var participantEmail: String

        binding.saveEventParticipantsButton.setOnClickListener {
            participantName = binding.enterParticipantName.text.toString()
            participantDesc = binding.enterParticipantDesc.text.toString()
            participantEmail = binding.enterParticipantEmail.text.toString()

            var participant = Participant(participantName, participantDesc, participantEmail)
            onAddParticipantListener?.invoke(participant)
            dismiss()
        }
    }
}