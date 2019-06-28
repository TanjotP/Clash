package com.danceapp.clash

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.danceapp.clash.databinding.SelectAccountPageBinding

class SelectAccountActivity : AppCompatActivity() {
    private var binding: SelectAccountPageBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.select_account_page)
        setupViews()
    }

    fun setupViews(){
        binding?.toolbar?.headerTitle?.setText(R.string.select_user_type)
        binding?.toolbar?.headerDescription?.setText(R.string.select_what_user_you_are)

        binding?.viewerSelection?.setOnClickListener {

        }

        binding?.adminSelection?.setOnClickListener {
            val intent = Intent(this, AdminHubActivity::class.java)
            startActivity(intent)
        }
    }
}
