package com.danceapp.clash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.danceapp.clash.databinding.ActivityAdminHubBinding

class AdminHubActivity : AppCompatActivity() {

    private var binding: ActivityAdminHubBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_hub)
        setupViews()
    }

    fun setupViews() {
        val adminEventDetailsFragment = AdminEventDetailsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, adminEventDetailsFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}