package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.danceapp.clash.FirebaseModule
import com.danceapp.clash.Participant
import com.danceapp.clash.databinding.ActivityAdminHubBinding
import com.danceapp.clash.R


class AdminHubActivity : AppCompatActivity(), AdminHubContract.View {

    companion object {
        private const val TAG = "AdminHubActivtiy"
    }

    private lateinit var binding: ActivityAdminHubBinding
    private var presenter: AdminHubContract.Presenter? = null
    val adminEventParticipantsFragment = AdminEventParticipantsFragment()

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
        binding.enterEventDetailsButton.visibility = View.VISIBLE
    }

    private fun setupPresenter() {
        val liveAgentPresenter = AdminHubPresenter(this@AdminHubActivity, firebaseModule)
        presenter = liveAgentPresenter

    }

    private fun setupViews() {
        binding.enterEventDetailsButton.setOnClickListener {
            setupAdminEventDetails()
            binding.enterEventDetailsButton.visibility = View.GONE
        }
    }

    private fun setupAdminEventDetails() {
        binding.toolbar.headerTitle.text = "Set your event details"
        binding.toolbar.headerDescription.visibility = View.GONE

        val adminEventDetailsFragment = AdminEventDetailsFragment()
        openFragment(adminEventDetailsFragment, "ADD")

        adminEventDetailsFragment.onSubmitEventDetailsListener = {
            presenter?.onSaveEventDetails(it)
        }
    }

    override fun setupAdminEventParticipant() {
        binding.toolbar.headerTitle.text = "Your current participants"
        binding.toolbar.headerDescription.visibility = View.GONE

        openFragment(adminEventParticipantsFragment, "REPLACE")

        adminEventParticipantsFragment.onAddParticipantSaveListener = {
            setupAdminEventAddParticipant()
        }

        adminEventParticipantsFragment.onSubmitParticipantListListener = {

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