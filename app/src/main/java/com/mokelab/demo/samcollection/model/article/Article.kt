package com.mokelab.demo.samcollection.model.article

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey val id: Int,
    val title: String,
    val content: String)