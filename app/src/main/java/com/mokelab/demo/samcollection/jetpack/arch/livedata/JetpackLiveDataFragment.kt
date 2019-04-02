package com.mokelab.demo.samcollection.jetpack.arch.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.JetpackLivedataFragmentBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JetpackLiveDataFragment: BindingFragment<JetpackLivedataFragmentBinding>(),
    CoroutineScope{

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var viewModel: JetpackLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProviders.of(this).get(JetpackLiveDataViewModel::class.java)
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
        // Note: It's not good to do async operation here.
        //       Configuration change(ex. rotation) cancels operation..
        launch {
            // simulate network communication
            val user = withContext(Dispatchers.IO) {
                Thread.sleep(3000)
                User("moke", "moke@example.com")
            }
            viewModel.user.value = user
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineContext.cancelChildren()
    }
}