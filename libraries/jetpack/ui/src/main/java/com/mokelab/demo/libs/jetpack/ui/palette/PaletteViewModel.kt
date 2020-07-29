package com.mokelab.demo.libs.jetpack.ui.palette

import android.app.Application
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.mokelab.demo.libs.jetpack.ui.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PaletteViewModel(val app: Application): AndroidViewModel(app) {
    val palette = MutableLiveData<Palette>()

    fun generate() {
        viewModelScope.launch {
            val p = withContext(Dispatchers.IO) {
                val bmp = BitmapFactory.decodeResource(app.resources, R.drawable.moke)
                Palette.from(bmp).generate()
            }
            palette.value = p
        }
    }
}