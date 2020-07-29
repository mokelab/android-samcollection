package com.mokelab.demo.libs.jetpack.arch

import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackArchTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_arch).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
/*
        0 -> this.navigate(R.id.action_jetpackArch_to_jetpackDatabinding)
        1 -> this.navigate(R.id.action_jetpackArchTop_to_jetpackLiveData)
        2 -> this.navigate(R.id.action_jetpackArch_to_ViewModel)
        3 -> this.navigate(R.id.action_jetpackArch_to_Room)

 */
        else -> println("nop")
    }
}