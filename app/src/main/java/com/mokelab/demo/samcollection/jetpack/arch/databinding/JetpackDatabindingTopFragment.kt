package com.mokelab.demo.samcollection.jetpack.arch.databinding

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackDatabindingTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_databinding).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_jetpackArchTop_to_jetpackLiveData)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}