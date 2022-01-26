package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainwithnav_jan20.databinding.FragmentPasswordBinding
import com.example.lonelymountainwithnav_jan20.ui.viewModel.LonelyMountainViewModel

class PasswordFragment: Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get()=_binding!!
    private lateinit var viewModel: LonelyMountainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[LonelyMountainViewModel::class.java]
        with(binding){
            val password = passwordEt.editText?.text.toString()

            toInfoBtn.setOnClickListener {
                viewModel.addPassword(password)

                val user=User(
                    viewModel.firstName.value.toString(),
                    viewModel.surname.value.toString(),
                    viewModel.email.value.toString(),
                    viewModel.password.value.toString())

                viewModel.addUser(user)
                val direction =
                    PasswordFragmentDirections.passwordFragmentToInfoFragmentAction()
                findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}