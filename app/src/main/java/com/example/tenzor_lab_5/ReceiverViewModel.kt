package com.example.tenzor_lab_5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {

    private val message = MutableLiveData<String>()

    fun storeMessage(message: String) {
        this.message.postValue(message)
    }

    fun getMessage(): MutableLiveData<String> {
        return message
    }
}