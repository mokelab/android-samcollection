package com.mokelab.demo.samcollection.jetpack

import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_top).toList()

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> println("0")
        else -> println("nop")
    }
}