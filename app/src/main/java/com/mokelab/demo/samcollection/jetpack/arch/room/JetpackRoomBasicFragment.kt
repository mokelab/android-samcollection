package com.mokelab.demo.samcollection.jetpack.arch.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.R
import com.mokelab.demo.samcollection.databinding.JetpackRoomBasicFragmentBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JetpackRoomBasicFragment: BindingFragment<JetpackRoomBasicFragmentBinding>(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var viewModel: JetpackRoomBasicViewModel
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProviders.of(requireActivity()).get(JetpackRoomBasicViewModel::class.java)
    }

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackRoomBasicFragmentBinding {
        val binding = JetpackRoomBasicFragmentBinding.inflate(inflater, container, false)

        binding.recycler.layoutManager = LinearLayoutManager(inflater.context, LinearLayoutManager.VERTICAL, false)
        this.adapter = ArticleAdapter(inflater.context, this.listener)
        binding.recycler.adapter = this.adapter

        binding.fab.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_jetpackRoomBasic_to_Create)
        }

        return binding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel.dao.getAll().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private val listener = View.OnClickListener {
        val position = binding.recycler.getChildAdapterPosition(it)
        val article = adapter.getItemAtPosition(position)
        launch {
            withContext(Dispatchers.IO) {
                viewModel.dao.delete(article)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineContext.cancelChildren()
    }


}