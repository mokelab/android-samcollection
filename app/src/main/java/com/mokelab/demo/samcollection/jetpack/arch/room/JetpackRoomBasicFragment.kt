package com.mokelab.demo.samcollection.jetpack.arch.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.JetpackRoomBasicFragmentBinding

class JetpackRoomBasicFragment: BindingFragment<JetpackRoomBasicFragmentBinding>() {

    private lateinit var viewModel: JetpackRoomBasicViewModel
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProviders.of(this).get(JetpackRoomBasicViewModel::class.java)
    }

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackRoomBasicFragmentBinding {
        val binding = JetpackRoomBasicFragmentBinding.inflate(inflater, container, false)

        binding.recycler.layoutManager = LinearLayoutManager(inflater.context, LinearLayoutManager.VERTICAL, false)
        this.adapter = ArticleAdapter(inflater.context)

        return binding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel.dao.getAll().observe(this, Observer {
            adapter.submitList(it)
        })
    }


}