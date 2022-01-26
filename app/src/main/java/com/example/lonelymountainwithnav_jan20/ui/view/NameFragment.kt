package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
    private lateinit var viewModel: LonelyMountainViewModel

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
        viewModel=ViewModelProvider(requireActivity())[LonelyMountainViewModel::class.java]
        with(binding){
            var firstName = firstNameEt.editText?.text.toString()
            var surname = surnameEt.editText?.text.toString()

            toEmailBtn.setOnClickListener {
                viewModel.addFirstName(firstName)
                viewModel.addSurname(surname)
                val direction= NameFragmentDirections.nameFragmentToEmailFragmentAction()
                findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}