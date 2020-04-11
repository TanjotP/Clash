package com.danceapp.clash.AdminHub

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import com.danceapp.clash.FirebaseModule
import com.danceapp.clash.Participant
import com.danceapp.clash.databinding.ActivityAdminHubBinding
import com.danceapp.clash.R


class AdminHubActivity : AppCompatActivity(), AdminHubContract.View {

    companion object {
        private const val TAG = "AdminHubActivtiy"
        private const val STATE_HUB = 0
        private const val STATE_EVENT_DETAILS = 1
        private const val STATE_EVENT_PARTICIPANT_LIST = 2
        private const val STATE_LANDING_PAGE = 3

    }


    private lateinit var binding: ActivityAdminHubBinding
    private var presenter: AdminHubContract.Presenter? = null
    private val adminEventParticipantsFragment = AdminEventParticipantsFragment()
    private var currentState = -1
    var firebaseModule = FirebaseModule()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_hub)
        setupViews()
    }

    override fun onResume() {
        super.onResume()
        if (presenter == null) {
            setupPresenter()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (currentState == STATE_EVENT_DETAILS) {
            currentState = STATE_HUB
        }
        if(currentState == STATE_EVENT_PARTICIPANT_LIST ) {
            currentState = STATE_EVENT_DETAILS
        }
        if (currentState != STATE_HUB) {
            binding.enterEventDetailsButton.visibility = View.GONE
        } else {
            binding.enterEventDetailsButton.visibility = View.VISIBLE
        }
    }

    private fun setupPresenter() {
        val liveAgentPresenter = AdminHubPresenter(this@AdminHubActivity, firebaseModule)
        presenter = liveAgentPresenter

    }

    private fun setupViews() {
        currentState = STATE_HUB
        binding.enterEventDetailsButton.visibility = View.VISIBLE
        binding.enterEventDetailsButton.setOnClickListener {
            setupAdminEventDetails()
            binding.enterEventDetailsButton.visibility = View.GONE
        }
    }

    private fun setupAdminEventDetails() {
        binding.toolbar.headerTitle.text = "Set your event details"
        binding.toolbar.headerDescription.visibility = View.GONE
        currentState = STATE_EVENT_DETAILS

        val adminEventDetailsFragment = AdminEventDetailsFragment()
        openFragment(adminEventDetailsFragment, "ADD")

        adminEventDetailsFragment.onSubmitEventDetailsListener = {
            presenter?.onSaveEventDetails(it)
        }
    }

    override fun setupAdminEventParticipant() {
        binding.toolbar.headerTitle.text = "Your current participants"
        binding.toolbar.headerDescription.visibility = View.GONE
        currentState = STATE_EVENT_PARTICIPANT_LIST

        openFragment(adminEventParticipantsFragment, "REPLACE")

        adminEventParticipantsFragment.onAddParticipantSaveListener = {
            setupAdminEventAddParticipant()
        }

        adminEventParticipantsFragment.onSubmitParticipantListListener = {
            setupAdminLandingPage()
        }


    }

    private fun setupAdminEventAddParticipant() {

        var adminEventAddParticipantFragment = AdminEventAddParticipantFragment()
        adminEventAddParticipantFragment.show(supportFragmentManager, "")

        adminEventAddParticipantFragment.onAddParticipantListener = {
            presenter?.onAddParticipant(it)
        }

    }

    override fun updateParticipantList(participant: Participant) {
        adminEventParticipantsFragment.updateParticipantListForAdapter(participant)
    }

    private fun setupAdminLandingPage() {
        currentState = STATE_LANDING_PAGE

        val adminEventLandingPage = AdminEventLandingPage()
        openFragment(adminEventLandingPage, "REPLACE")
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(binding.root, String.format(message), Snackbar.LENGTH_LONG).show()
    }

    private fun openFragment(fragment: Fragment, action: String) {
        val transaction = supportFragmentManager.beginTransaction()
        if (action.equals("ADD")) {
            transaction.add(R.id.fragment_container, fragment)
        } else if (action.equals("REPLACE")) {
            transaction.replace(R.id.fragment_container, fragment)
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }
}