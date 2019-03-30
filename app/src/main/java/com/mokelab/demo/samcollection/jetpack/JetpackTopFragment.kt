package com.mokelab.demo.samcollection.jetpack

import com.mokelab.demo.samcollection.MenuListFragment
import com.mokelab.demo.samcollection.R

class JetpackTopFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = listOf(
        getString(R.string.jetpack_top_foundation),
        getString(R.string.jetpack_top_architecture),
        getString(R.string.jetpack_top_behavior),
        getString(R.string.jetpack_top_ui)
    )

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> println("0")
        else -> println("nop")
    }
}