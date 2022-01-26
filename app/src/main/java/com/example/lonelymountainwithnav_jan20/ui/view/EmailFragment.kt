package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainwithnav_jan20.databinding.FragmentEmailBinding
import com.example.lonelymountainwithnav_jan20.ui.viewModel.LonelyMountainViewModel

class EmailFragment: Fragment() {

    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding get()=_binding!!
    private lateinit var viewModel: LonelyMountainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity())[LonelyMountainViewModel::class.java]
        with(binding){
            var email = emailEt.editText?.text.toString()

            toPasswordBtn.setOnClickListener {
                viewModel.addEmail(email)
                val direction =
                    EmailFragmentDirections.emailFragmentToPasswordFragmentAction()
                findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

