package com.mokelab.demo.libs.jetpack.arch.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokelab.demo.libs.jetpack.arch.livedata.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JetpackLiveDataViewModel: ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val user = MutableLiveData<User>()

    fun loadUser() {
        if (loading.value == true) {
            return
        }
        loading.value = true
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                delay(3000)
                User("moke", "moke@example.com")
            }
            this@JetpackLiveDataViewModel.user.value = user
            loading.value = false
        }
    }

}