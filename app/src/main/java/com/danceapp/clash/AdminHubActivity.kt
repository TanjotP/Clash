package com.danceapp.clash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.danceapp.clash.databinding.ActivityAdminHubBinding

class AdminHubActivity : AppCompatActivity(), AdminHubContract.View {

    companion object {
        private const val TAG = "AdminHubActivtiy"
    }

    private var binding: ActivityAdminHubBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_hub)
        setupViews()
    }

    fun setupViews() {
        val adminEventDetailsFragment = AdminEventDetailsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, adminEventDetailsFragment)
        transaction.commit()
        adminEventDetailsFragment.onSubmitEventDetailsListener = {

        }
    }

    override fun showDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}