package com.example.lonelymountainwithnav_jan20.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lonelymountainwithnav_jan20.R
import com.example.lonelymountainwithnav_jan20.databinding.FragmentPasswordBinding
import com.example.lonelymountainwithnav_jan20.ui.viewModel.LonelyMountainViewModel

class PasswordFragment: Fragment() {
    private val args: PasswordFragmentArgs by navArgs()

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
        viewModel = ViewModelProvider(this)[LonelyMountainViewModel::class.java]
        with(binding){
            toInfoBtn.setOnClickListener {
                val password = passwordEt.toString()

                val directions =
                    PasswordFragmentDirections.passwordFragmentToInfoFragmentAction(
                        args.firstName,
                        args.surname,
                        args.email,
                        password
                    )

                findNavController().navigate(directions)
//                findNavController().navigate(R.id.password_fragment_to_info_fragment_action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}