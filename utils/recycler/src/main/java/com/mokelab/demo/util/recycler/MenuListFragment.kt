package com.mokelab.demo.util.recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mokelab.demo.util.recycler.databinding.MenuListFragmentBinding

abstract class MenuListFragment: Fragment(R.layout.menu_list_fragment) {
    private var _binding: MenuListFragmentBinding? = null
    private val binding: MenuListFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = MenuListFragmentBinding.bind(view)

        val adapter = MenuListAdapter {
            onMenuItemClicked(it)
        }
        adapter.submitList(onCreateMenuLabel())
        binding.recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

    abstract fun onCreateMenuLabel(): List<String>

    abstract fun onMenuItemClicked(position: Int)
}