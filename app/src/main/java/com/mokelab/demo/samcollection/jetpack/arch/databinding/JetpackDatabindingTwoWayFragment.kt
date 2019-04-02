package com.mokelab.demo.samcollection.jetpack.arch.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.JetpackDatabindingBasicFragmentBinding
import com.mokelab.demo.samcollection.databinding.JetpackDatabindingTwowayFragmentBinding

class JetpackDatabindingTwoWayFragment: BindingFragment<JetpackDatabindingTwowayFragmentBinding>() {
    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackDatabindingTwowayFragmentBinding {
        return JetpackDatabindingTwowayFragmentBinding.inflate(inflater, container, false)
    }
}