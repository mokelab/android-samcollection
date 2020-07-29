package com.mokelab.demo.libs.jetpack

import androidx.navigation.fragment.findNavController
import com.mokelab.demo.util.recycler.MenuListFragment

class JetpackTopFragment : MenuListFragment() {

    override fun onCreateMenuLabel() = resources.getStringArray(R.array.jetpack_top).toList()

    override fun onMenuItemClicked(position: Int) {
        when (position) {
            3 -> findNavController().navigate(R.id.action_jetpack_top_to_ui)
        }
    } /*
    when (position) {
        1 -> this.navigate(R.id.action_jetpackTop_to_jetpackArch)
        3 -> this.navigate(R.id.action_jetpackTop_to_jetpackUI)
        else -> println("nop")
    }
    */

    /*
    private fun navigate(action: Int) {
        Navigation.findNavController(view!!).navigate(action)
    }
     */

}