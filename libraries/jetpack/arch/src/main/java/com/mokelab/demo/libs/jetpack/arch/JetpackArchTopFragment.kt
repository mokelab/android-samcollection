package com.mokelab.demo.libs.jetpack.arch

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackArchTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_arch).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> findNavController().navigate(R.id.action_arch_top_to_databinding)
        1 -> findNavController().navigate(R.id.action_arch_top_to_livedata)
        2 -> findNavController().navigate(R.id.action_arch_top_to_viewmodel)
/*
        0 -> this.navigate(R.id.action_jetpackArch_to_jetpackDatabinding)
        1 -> this.navigate(R.id.action_jetpackArchTop_to_jetpackLiveData)
        2 -> this.navigate(R.id.action_jetpackArch_to_ViewModel)
        3 -> this.navigate(R.id.action_jetpackArch_to_Room)

 */
        else -> println("nop")
    }
}