package com.mokelab.demo.libs.jetpack.arch.viewmodel

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.libs.jetpack.arch.R
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackViewModelTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_viewmodel).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> findNavController().navigate(R.id.action_viewmodel_to_livedata)
        1 -> findNavController().navigate(R.id.action_viewmodel_to_scope)
        else -> println("nop")
    }
}