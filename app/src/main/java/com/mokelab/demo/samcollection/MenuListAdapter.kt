package com.mokelab.demo.samcollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.mokelab.demo.binding.BindingListAdapter
import com.mokelab.demo.binding.BindingViewHolder
import com.mokelab.demo.samcollection.databinding.SingleLineItemBinding

class MenuListAdapter(context: Context, private val listener:View.OnClickListener):
    BindingListAdapter<String, SingleLineItemBinding>(itemCallbacks) {

    companion object {
        val itemCallbacks = object: DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    private val inflater = LayoutInflater.from(context)

    override fun onCreateBinding(parent: ViewGroup): SingleLineItemBinding {
        val binding = SingleLineItemBinding.inflate(this.inflater, parent, false)
        binding.root.setOnClickListener(this.listener)
        return binding
    }

    override fun onBindViewHolder(holder: BindingViewHolder<SingleLineItemBinding>, position: Int) {
        val item = getItem(position)
        holder.binding.text.text = item
        holder.binding.executePendingBindings()
    }
}