package com.mokelab.demo.libs.jetpack.ui

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackUIFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_ui).toList()

    override fun onMenuItemClicked(position: Int) {
        when (position) {
            0 -> findNavController().navigate(R.id.action_jetpack_ui_to_palette)
        }
    }
}