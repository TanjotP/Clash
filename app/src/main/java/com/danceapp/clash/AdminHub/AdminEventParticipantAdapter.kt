package com.danceapp.clash.AdminHub

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.danceapp.clash.Participant
import com.danceapp.clash.databinding.ParticipantItemBinding

class AdminEventParticipantAdapter(private val items: ArrayList<Participant>) : RecyclerView.Adapter<AdminEventParticipantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ParticipantItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])


    inner class ViewHolder(val binding: ParticipantItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Participant) {
            with(binding) {
                participantName.text = item.teamName
                participantDesc.text = item.teamDescription
                participantEmail.text = item.teamEmail
            }
        }
    }
}