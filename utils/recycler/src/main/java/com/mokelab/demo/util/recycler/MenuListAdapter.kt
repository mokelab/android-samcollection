package com.mokelab.demo.util.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mokelab.demo.util.recycler.databinding.MenuListItemBinding

class MenuListAdapter(private val listener: (Int)->Unit): ListAdapter<String, MenuListAdapter.ViewHolder>(callbacks) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuListItemBinding.inflate(inflater, parent, false)
        val viewHolder = ViewHolder(binding)
        binding.root.setOnClickListener {
            val position = viewHolder.adapterPosition
            listener(position)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class ViewHolder(private val binding: MenuListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(value: String) {
            binding.text.text = value
        }
    }

    companion object {
        private val callbacks = object: DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String)= oldItem == newItem
        }
    }

}