package com.example.lonelymountainwithnav_jan20.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lonelymountainwithnav_jan20.ui.view.*
import java.util.jar.Attributes

class LonelyMountainViewModel: ViewModel() {
    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()

    private var _firstName: MutableLiveData<String> =MutableLiveData()
    val firstName: LiveData<String> get() = _firstName

    private var _surname: MutableLiveData<String> =MutableLiveData()
    val surname: LiveData<String> get() = _surname

    private var _email: MutableLiveData<String> =MutableLiveData()
    val email: LiveData<String> get() = _email

    private var _password: MutableLiveData<String> =MutableLiveData()
    val password: LiveData<String> get() = _password

//    init{
//        _users.value = userList
//    }

    fun addFirstName(firstName: String) {
        _firstName.value=firstName
    }
    fun addSurname(surname: String) {
        _surname.value=surname
    }
    fun addEmail(email: String) {
        _email.value=email
    }
    fun addPassword(password: String) {
        _password.value=password
    }
    fun addUser(user: User){
        userList.add(user)

        _users.value = userList
    }


}