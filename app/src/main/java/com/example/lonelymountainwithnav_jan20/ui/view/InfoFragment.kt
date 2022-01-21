package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lonelymountainwithnav_jan20.R
import com.example.lonelymountainwithnav_jan20.databinding.FragmentInfoBinding
import com.example.lonelymountainwithnav_jan20.ui.viewModel.LonelyMountainViewModel


class InfoFragment: Fragment() {
    private val args: InfoFragmentArgs by navArgs()

    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding get() = _binding!!
    private lateinit var viewModel: LonelyMountainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LonelyMountainViewModel::class.java]
        with(binding) {

            submitBtn.setOnClickListener {
                findNavController().navigate(R.id.pop_up_info_fragment_to_start_page_fragment_action)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}