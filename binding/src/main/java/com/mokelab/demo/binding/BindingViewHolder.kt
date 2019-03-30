package com.mokelab.demo.binding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingViewHolder<B: ViewDataBinding>(val binding: B): RecyclerView.ViewHolder(binding.root)