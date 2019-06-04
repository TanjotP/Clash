package com.danceapp.clash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.danceapp.clash.databinding.AdminHubPageBinding
import kotlinx.android.synthetic.main.toolbar_header.*

class AdminHubPage : AppCompatActivity(){

    private lateinit var binding : AdminHubPageBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this,R.layout.select_account_page)
        setupViews()
    }

    fun setupViews(){
        binding.toolbar.headerTitle.setText("Set your event details")
        binding.toolbar.headerDescription.visibility = View.GONE


    }
}