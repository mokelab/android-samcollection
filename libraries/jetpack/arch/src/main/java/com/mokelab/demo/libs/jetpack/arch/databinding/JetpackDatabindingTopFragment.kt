package com.mokelab.demo.libs.jetpack.arch.databinding

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.libs.jetpack.arch.R
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackDatabindingTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_databinding).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> findNavController().navigate(R.id.action_databinding_to_basic)
        1 -> findNavController().navigate(R.id.action_databinding_to_twoway)
        else -> println("nop")
    }
}