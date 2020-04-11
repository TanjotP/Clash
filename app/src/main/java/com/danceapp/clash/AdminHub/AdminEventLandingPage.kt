package com.danceapp.clash.AdminHub

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.R
import com.danceapp.clash.databinding.FragmentAdminEventLandingPageBinding

class AdminEventLandingPage() : Fragment() {
    companion object {
        private const val TAG = "AdminEventLandPage"
    }

    private lateinit var binding: FragmentAdminEventLandingPageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentAdminEventLandingPageBinding>(
            inflater,
            R.layout.fragment_admin_event_landing_page,
            container,
            false
        )
        //TODO: populate a new list pulled from firebase post and persist this page when user logs in
        return binding.root
    }
}