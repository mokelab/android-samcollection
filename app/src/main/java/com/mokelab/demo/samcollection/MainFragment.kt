package com.mokelab.demo.samcollection

import androidx.navigation.Navigation
import com.mokelab.demo.util.recycler.MenuListFragment

class MainFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = listOf(
        getString(R.string.main_jetpack)
    )

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_main_to_nav_jetpack)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(requireView()).navigate(action)
    }
}