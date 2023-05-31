package com.ruliam.testsinandroid.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruliam.testsinandroid.R

class RegisterFragment : Fragment() {

    //private var _binding: RegisterFragmentBinding? = null
//
//    private var binding get() = _binding

    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
////        _binding = RegisterFragmentBinding.inflate(inflater, container, false)
////        return binding.root
//    }

}