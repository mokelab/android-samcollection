package com.mokelab.demo.samcollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.databinding.MenuListFragment2Binding

abstract class MenuListFragment : BindingFragment<MenuListFragment2Binding>() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: MenuListAdapter

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): MenuListFragment2Binding {
        val binding = MenuListFragment2Binding.inflate(inflater, container, false)

        this.adapter = MenuListAdapter(requireContext(), this.listener)
        this.adapter.submitList(this.onCreateMenuLabel())

        this.recycler = binding.recycler
        this.recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        this.recycler.adapter = this.adapter

        return binding
    }

    private val listener =  View.OnClickListener {
        val position = this.recycler.getChildAdapterPosition(it)
        this.onMenuItemClicked(position)
    }

    abstract fun onCreateMenuLabel(): List<String>

    abstract fun onMenuItemClicked(position: Int)

}