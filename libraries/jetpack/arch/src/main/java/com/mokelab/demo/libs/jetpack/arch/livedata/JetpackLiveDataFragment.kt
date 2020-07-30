package com.mokelab.demo.libs.jetpack.arch.livedata

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mokelab.demo.libs.jetpack.arch.R
import com.mokelab.demo.libs.jetpack.arch.databinding.JetpackLivedataFragmentBinding

class JetpackLiveDataFragment: Fragment(R.layout.jetpack_livedata_fragment) {
    private var _binding: JetpackLivedataFragmentBinding? = null
    private val binding: JetpackLivedataFragmentBinding get() = _binding!!

    private val vm: JetpackLiveDataViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = JetpackLivedataFragmentBinding.bind(view)

        this.vm.loading.observe(viewLifecycleOwner) {
            binding.progress.visibility = if (it == true) View.VISIBLE else View.GONE
        }
        this.vm.user.observe(viewLifecycleOwner) {
            val user = it ?: return@observe
            binding.nameText.text = user.name
            binding.emailText.text = user.email
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

    override fun onStart() {
        super.onStart()
        vm.loadUser()
    }
}