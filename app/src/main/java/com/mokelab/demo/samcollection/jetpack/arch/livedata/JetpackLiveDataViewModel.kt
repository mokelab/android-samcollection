package com.mokelab.demo.samcollection.jetpack.arch.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JetpackLiveDataViewModel: ViewModel() {
    val user = MutableLiveData<User>()
}