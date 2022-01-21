package com.example.lonelymountainwithnav_jan20.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lonelymountainwithnav_jan20.ui.view.User

class LonelyMountainViewModel: ViewModel() {
    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()


    fun addUser(user:User) {

        userList.add(user)

        _users.value = userList
    }
}