package com.mokelab.demo.samcollection.jetpack.arch.databinding

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackDatabindingTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_databinding).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_jetpackDatabinding_to_Basic)
        1 -> this.navigate(R.id.action_jetpackDatabinding_to_twoWay)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}