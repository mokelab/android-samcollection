package com.mokelab.demo.libs.jetpack

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackTopFragment : MenuListFragment() {

    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_top).toList()

    override fun onMenuItemClicked(position: Int) {
        when (position) {
            1 -> findNavController().navigate(R.id.action_jetpack_top_to_arch)
            3 -> findNavController().navigate(R.id.action_jetpack_top_to_ui)
        }
    }
}