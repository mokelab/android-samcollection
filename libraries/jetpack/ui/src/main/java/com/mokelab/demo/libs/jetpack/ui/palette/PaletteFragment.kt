package com.mokelab.demo.libs.jetpack.ui.palette

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mokelab.demo.libs.jetpack.ui.R
import com.mokelab.demo.libs.jetpack.ui.databinding.PaletteFragmentBinding

class PaletteFragment: Fragment(R.layout.palette_fragment) {
    private var _binding: PaletteFragmentBinding? = null
    private val binding: PaletteFragmentBinding get() = _binding!!

    private val vm: PaletteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = PaletteFragmentBinding.bind(view)

        vm.palette.observe(viewLifecycleOwner) {
            binding.vibrantView.setBackgroundColor(it.vibrantSwatch?.rgb ?: Color.BLACK)
            binding.dominantView.setBackgroundColor(it.dominantSwatch?.rgb ?: Color.BLACK)
            binding.lightVibrantView.setBackgroundColor(it.lightVibrantSwatch?.rgb ?: Color.BLACK)
            binding.lightMutedView.setBackgroundColor(it.lightMutedSwatch?.rgb ?: Color.BLACK)
            binding.darkVibrantView.setBackgroundColor(it.darkVibrantSwatch?.rgb ?: Color.BLACK)
            binding.darkMutedView.setBackgroundColor(it.darkMutedSwatch?.rgb ?: Color.BLACK)
        }
    }

    override fun onStart() {
        super.onStart()
        vm.generate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

}