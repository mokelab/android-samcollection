package com.mokelab.demo.binding

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BindingListAdapter<T, U: ViewDataBinding>(callback: DiffUtil.ItemCallback<T>):
    ListAdapter<T, BindingViewHolder<U>>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<U> {
        val binding = this.onCreateBinding(parent)
        return BindingViewHolder(binding)
    }

    abstract fun onCreateBinding(parent: ViewGroup): U
}