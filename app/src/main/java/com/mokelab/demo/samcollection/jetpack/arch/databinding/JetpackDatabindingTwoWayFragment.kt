package com.mokelab.demo.samcollection.jetpack.arch.databinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mokelab.demo.samcollection.R
import com.mokelab.demo.samcollection.databinding.JetpackDatabindingTwowayFragmentBinding

class JetpackDatabindingTwoWayFragment: Fragment(R.layout.jetpack_databinding_twoway_fragment) {
    private var _binding: JetpackDatabindingTwowayFragmentBinding? = null
    private val binding: JetpackDatabindingTwowayFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = JetpackDatabindingTwowayFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}