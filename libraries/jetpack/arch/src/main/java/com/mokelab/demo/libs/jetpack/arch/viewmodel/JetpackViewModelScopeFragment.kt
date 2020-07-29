package com.mokelab.demo.libs.jetpack.arch.viewmodel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mokelab.demo.libs.jetpack.arch.R
import com.mokelab.demo.libs.jetpack.arch.databinding.JetpackViewmodelScopeFragmentBinding

class JetpackViewModelScopeFragment: Fragment(R.layout.jetpack_viewmodel_scope_fragment) {
    private var _binding: JetpackViewmodelScopeFragmentBinding? = null
    private val binding: JetpackViewmodelScopeFragmentBinding get() = _binding!!

    private val vm: JetpackViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = JetpackViewmodelScopeFragmentBinding.bind(view)

        this.vm.user.observe(viewLifecycleOwner) {
            val user = it ?: return@observe
            binding.nameText.text = user.name
            binding.emailText.text = user.email
            binding.loading.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
        this.vm.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}