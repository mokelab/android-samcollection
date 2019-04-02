package com.mokelab.demo.samcollection.jetpack.arch

import androidx.navigation.Navigation
import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackArchTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_arch).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> this.navigate(R.id.action_jetpackArch_to_jetpackDatabinding)
        1 -> this.navigate(R.id.action_jetpackArchTop_to_jetpackLiveData)
        else -> println("nop")
    }

    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
}