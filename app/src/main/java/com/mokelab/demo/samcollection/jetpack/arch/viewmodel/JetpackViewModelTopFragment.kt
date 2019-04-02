package com.mokelab.demo.samcollection.jetpack.arch.viewmodel

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackViewModelTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_viewmodel).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_jetpackViewModel_to_LiveData)
        1 -> this.navigate(R.id.action_jetpackViewModel_to_Scope)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}