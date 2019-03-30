package com.mokelab.demo.samcollection

class MainFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = listOf("")

    override fun onMenuItemClicked(position: Int) = when (position) {
        0 -> println("0")
        else -> println("nop")
    }
}