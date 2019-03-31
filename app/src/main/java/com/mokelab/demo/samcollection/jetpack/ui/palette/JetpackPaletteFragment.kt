package com.mokelab.demo.samcollection.jetpack.ui.palette

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.R
import com.mokelab.demo.samcollection.databinding.JetpackPaletteFragmentBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JetpackPaletteFragment: BindingFragment<JetpackPaletteFragmentBinding>(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackPaletteFragmentBinding {
        return JetpackPaletteFragmentBinding.inflate(inflater, container, false)
    }

    override fun onStart() {
        super.onStart()
        launch {
            val palette = withContext(Dispatchers.IO) {
                val bmp = BitmapFactory.decodeResource(resources, R.drawable.moke)
                Palette.from(bmp).generate()
            }
            binding.vibrantView.setBackgroundColor(palette.vibrantSwatch?.rgb ?: Color.BLACK)
            binding.dominantView.setBackgroundColor(palette.dominantSwatch?.rgb ?: Color.BLACK)
            binding.lightVibrantView.setBackgroundColor(palette.lightVibrantSwatch?.rgb ?: Color.BLACK)
            binding.lightMutedView.setBackgroundColor(palette.lightMutedSwatch?.rgb ?: Color.BLACK)
            binding.darkVibrantView.setBackgroundColor(palette.darkVibrantSwatch?.rgb ?: Color.BLACK)
            binding.darkMutedView.setBackgroundColor(palette.darkMutedSwatch?.rgb ?: Color.BLACK)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancelChildren()
    }

}