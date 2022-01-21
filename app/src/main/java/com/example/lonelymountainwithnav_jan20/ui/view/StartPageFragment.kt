package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lonelymountainwithnav_jan20.databinding.FragmentStartPageBinding
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainwithnav_jan20.R

class StartPageFragment: Fragment() {
    private var _binding: FragmentStartPageBinding? = null
    private val binding: FragmentStartPageBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentStartPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            createAccountBtn.setOnClickListener {
                findNavController().navigate(R.id.start_page_fragment_to_name_fragment_action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}