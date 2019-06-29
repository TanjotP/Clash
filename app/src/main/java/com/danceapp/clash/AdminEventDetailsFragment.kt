package com.danceapp.clash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danceapp.clash.databinding.FragmentAdminEventDetailsBinding

class AdminEventDetailsFragment : Fragment() {

    companion object {
        private const val TAG = "AdminEventDetailsFrag"
    }

    private var binding: FragmentAdminEventDetailsBinding? = null
    var onSubmitEventDetailsListener: (() -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentAdminEventDetailsBinding>(
            inflater,
            R.layout.fragment_admin_event_details,
            container,
            false
        )
        setupViews()
        return binding?.root
    }

    fun setupViews() {
        binding?.toolbar?.headerTitle?.text = "Set your event details"
        binding?.toolbar?.headerDescription?.visibility = View.GONE
        binding?.eventDetailsButton?.setOnClickListener {
            onSubmitEventDetailsListener?.invoke() ?: Log.e(TAG, "onSubmitEventDetailsListener not set")
        }
    }
}