package com.mokelab.demo.samcollection.model.article

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDAO {
    @Insert
    fun insert(article: Article)

    @Query("SELECT * from article WHERE id=:id")
    fun getById(id: Int): LiveData<Article>

    @Update
    fun update(article: Article)

    @Delete
    fun delete(article: Article)
}