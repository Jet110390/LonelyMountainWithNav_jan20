package com.example.lonelymountainwithnav_jan20.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lonelymountainwithnav_jan20.databinding.UserItemBinding

class UserAdapter(private val userList: List<User>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater,parent,false)
        return UserViewHolder(binding)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class UserViewHolder(private val binding: UserItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user:User) {
            with(binding) {
                firstNameInfoTv.text = user.firstName
                surnameInfoTv.text = user.surname
                emailInfoTv.text = user.email
                passwordInfoTv.text = user.password
            }

        }
    }
}