package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.lonelymountainwithnav_jan20.databinding.FragmentNameBinding
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainwithnav_jan20.R
import com.example.lonelymountainwithnav_jan20.ui.viewModel.LonelyMountainViewModel

class NameFragment: Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get()=_binding!!

    private lateinit var viewModel:LonelyMountainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentNameBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(LonelyMountainViewModel::class.java)
        with(binding){
            toEmailBtn.setOnClickListener {

                val firstName = firstNameEt.editText?.text.toString()
                val surname = surnameEt.editText?.text.toString()
                val direction =
                    NameFragmentDirections.nameFragmentToEmailFragmentAction(
                        firstName,
                        surname
                    )

                findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}