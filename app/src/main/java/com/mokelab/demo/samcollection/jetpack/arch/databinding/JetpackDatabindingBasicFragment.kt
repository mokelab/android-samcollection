package com.mokelab.demo.samcollection.jetpack.arch.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.JetpackDatabindingBasicFragmentBinding

class JetpackDatabindingBasicFragment: BindingFragment<JetpackDatabindingBasicFragmentBinding>() {
    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackDatabindingBasicFragmentBinding {
        val user = User("moke", "moke@example.com")
        val binding = JetpackDatabindingBasicFragmentBinding.inflate(inflater, container, false)
        binding.user = user
        return binding
    }
}