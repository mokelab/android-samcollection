package com.mokelab.demo.samcollection.jetpack.arch.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.JetpackLivedataFragmentBinding
import com.mokelab.demo.samcollection.jetpack.arch.livedata.User

class JetpackViewModelScopeFragment: BindingFragment<JetpackLivedataFragmentBinding>() {

    private lateinit var viewModel: JetpackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProviders.of(this).get(JetpackViewModel::class.java)
    }

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackLivedataFragmentBinding {
        val binding = JetpackLivedataFragmentBinding.inflate(inflater, container, false)
        binding.loading = true
        return binding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel.user.observe(this, Observer<User> {
            val user = it ?: return@Observer
            binding.nameText.text = user.name
            binding.emailText.text = user.email
            binding.loading = false
        })
    }

    override fun onStart() {
        super.onStart()
        this.viewModel.load()
    }
}