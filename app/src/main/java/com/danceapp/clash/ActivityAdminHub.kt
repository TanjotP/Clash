package com.danceapp.clash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.danceapp.clash.databinding.ActivityAdminHubBinding

class ActivityAdminHub : AppCompatActivity(){

    private var binding: ActivityAdminHubBinding? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_hub)
        setupViews()
    }

    fun setupViews(){
        binding?.adminOptionsList?.layoutManager = GridLayoutManager(this, 2)
        //binding?.adminOptionsList?.adapter =
    }
}