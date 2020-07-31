package com.mokelab.demo.libs.jetpack.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mokelab.demo.libs.jetpack.databinding.databinding.JetpackDatabindingBasicFragmentBinding

class JetpackDatabindingBasicFragment: Fragment(R.layout.jetpack_databinding_basic_fragment) {
    private var _binding: JetpackDatabindingBasicFragmentBinding? = null
    private val binding: JetpackDatabindingBasicFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = JetpackDatabindingBasicFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = User("moke", "moke@example.com")
        binding.user = user
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}