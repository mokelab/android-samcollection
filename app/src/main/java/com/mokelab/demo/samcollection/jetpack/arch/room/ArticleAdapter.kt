package com.mokelab.demo.samcollection.jetpack.arch.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mokelab.demo.binding.BindingViewHolder
import com.mokelab.demo.samcollection.databinding.ArticleItemBinding
import com.mokelab.demo.samcollection.model.article.Article

class ArticleAdapter(context: Context,
                     val listener: View.OnClickListener): ListAdapter<Article, BindingViewHolder<ArticleItemBinding>>(diffUtils) {
    private val inflater = LayoutInflater.from(context)

    companion object {
        val diffUtils = object: DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.content == newItem.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ArticleItemBinding> {
        val binding = ArticleItemBinding.inflate(this.inflater, parent, false)
        binding.root.setOnClickListener(this.listener)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ArticleItemBinding>, position: Int) {
        val article = getItem(position)
        holder.binding.article = article
        holder.binding.executePendingBindings()
    }

    fun getItemAtPosition(position: Int): Article = this.getItem(position)
}