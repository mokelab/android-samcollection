package com.mokelab.demo.libs.jetpack.ui

import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackUIFragment : MenuListFragment() {
    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_ui).toList()

    override fun onMenuItemClicked(position: Int) {

    } /*when (position) {
        0 -> this.navigate(R.id.action_jetpackUI_to_jetpackPalette)
        else -> println("nop")
    }


    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
    */
}