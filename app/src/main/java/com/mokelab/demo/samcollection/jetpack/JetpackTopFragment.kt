package com.mokelab.demo.samcollection.jetpack

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_top).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        1 -> this.navigate(R.id.action_jetpackTop_to_jetpackArch)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}