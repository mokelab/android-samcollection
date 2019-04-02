package com.mokelab.demo.samcollection.jetpack.arch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokelab.demo.samcollection.jetpack.arch.livedata.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JetpackViewModel: ViewModel() {
    private var loading = false
    val user = MutableLiveData<User>()

    fun load() {
        if (loading) {
            return
        }
        loading = true
        // viewModelScope is Main thread
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                delay(3000)
                User("moke", "moke@example.com")
            }
            this@JetpackViewModel.user.value = user
        }
    }
}