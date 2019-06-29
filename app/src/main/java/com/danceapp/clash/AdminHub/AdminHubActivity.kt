package com.danceapp.clash.AdminHub

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.danceapp.clash.databinding.ActivityAdminHubBinding
import com.danceapp.clash.R


class AdminHubActivity : AppCompatActivity(), AdminHubContract.View {

    companion object {
        private const val TAG = "AdminHubActivtiy"
    }

    private lateinit var binding: ActivityAdminHubBinding
    private var presenter: AdminHubContract.Presenter? = null

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

    private fun setupPresenter(){
        val liveAgentPresenter =
            AdminHubPresenter(this@AdminHubActivity)
        presenter = liveAgentPresenter

    }

    private fun setupViews() {
        binding.enterEventDetailsButton.setOnClickListener {
            setupAdminEventDetails()
            binding.enterEventDetailsButton.visibility = View.GONE
        }
    }

    private fun setupAdminEventDetails(){
        val adminEventDetailsFragment = AdminEventDetailsFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, adminEventDetailsFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        binding?.toolbar?.headerTitle?.text = "Set your event details"
        binding?.toolbar?.headerDescription?.visibility = View.GONE

        adminEventDetailsFragment.onSubmitEventDetailsListener = {
            presenter?.onSaveDetails(it)
        }
    }

    override fun showDialog(message: String) {
        Snackbar.make(binding.root, String.format(message), Snackbar.LENGTH_LONG).show()
    }
}