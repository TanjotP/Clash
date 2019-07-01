package com.danceapp.clash

data class Event(
    var eventCompany: String,
    var eventName: String,
    var eventDate: String,
    var participants: ArrayList<Participant>)