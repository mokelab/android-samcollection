package com.mokelab.demo.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<T: ViewDataBinding>: Fragment() {
    protected lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = this.onCreateViewDataBinding(inflater, container, savedInstanceState)
        return this.binding.root
    }

    abstract fun onCreateViewDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): T
}