package com.mokelab.demo.samcollection.model.article

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleDB: RoomDatabase() {
    abstract fun articleDAO(): ArticleDAO
}