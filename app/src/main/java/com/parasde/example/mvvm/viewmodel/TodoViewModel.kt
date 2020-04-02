package com.parasde.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.parasde.example.mvvm.model.Todo

class TodoViewModel: ViewModel() {
    // 2-way
    private val _todo: MutableLiveData<Todo> = MutableLiveData<Todo>().apply {
        value = Todo("", "")
    }
    val todo: LiveData<Todo>
        get() = _todo


    private val _showBtn: MutableLiveData<Unit> = MutableLiveData()
    val showBtn: LiveData<Unit>
        get() = _showBtn

    fun showToast() {
        _showBtn.value = Unit
    }
}