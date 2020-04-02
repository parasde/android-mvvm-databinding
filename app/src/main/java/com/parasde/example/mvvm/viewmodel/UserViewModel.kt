package com.parasde.example.mvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    /* ObservableField */

    val id: ObservableField<String> = ObservableField("User ID")
    fun setUserId(c: CharSequence) {
        id.set(c.toString())
    }

    /* LiveData */

    private val _name: MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "User Name"
    }
    val name: LiveData<String>
        get() = _name

    fun setUserName(c: CharSequence) {
        _name.value = c.toString()
    }


    private val _contact = MutableLiveData<String>()
    val contact: LiveData<String>
        get() = _contact

    fun setUserContact(c: CharSequence) {
        _contact.value = c.toString()
    }
}