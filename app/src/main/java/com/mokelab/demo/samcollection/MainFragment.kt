package com.mokelab.demo.samcollection

import androidx.navigation.Navigation

class MainFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = listOf(
        getString(R.string.main_jetpack)
    )

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_main_to_jetpackTop)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}