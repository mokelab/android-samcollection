package com.mokelab.demo.samcollection.jetpack.ui

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackUIFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_ui).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_jetpackUI_to_jetpackPalette)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}