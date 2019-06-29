package com.danceapp.clash

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.danceapp.clash.databinding.ActivityAdminHubBinding
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction


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

    private fun setupPresenter(){
        val liveAgentPresenter =
            AdminHubPresenter(this@AdminHubActivity)
        presenter = liveAgentPresenter

    }

    private fun setupViews() {
        val adminEventDetailsFragment = AdminEventDetailsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, adminEventDetailsFragment)
        transaction.commit()
        adminEventDetailsFragment.onSubmitEventDetailsListener = {
            presenter?.onGenerateKey()
        }
    }

    override fun showDialog(message: String) {
        Snackbar.make(binding.root, String.format(message), Snackbar.LENGTH_LONG).show()
    }
}