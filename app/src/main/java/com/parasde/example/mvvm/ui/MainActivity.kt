package com.parasde.example.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.parasde.example.mvvm.R
import com.parasde.example.mvvm.databinding.ActivityMainBinding
import com.parasde.example.mvvm.viewmodel.TodoViewModel
import com.parasde.example.mvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        val userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
        binding.userVM = userViewModel

        val todoViewModel = ViewModelProvider(this, viewModelFactory).get(TodoViewModel::class.java)
        binding.todoVM = todoViewModel

        binding.lifecycleOwner = this

        userViewModel.name.observe(this, Observer {
            userNameTv.text = it
        })

        todoViewModel.showBtn.observe(this, Observer {
            Toast.makeText(this, "${todoViewModel.todo.value?.title} - ${todoViewModel.todo.value?.content}", Toast.LENGTH_SHORT).show()
        })
    }
}
