package com.mokelab.demo.samcollection.jetpack.arch.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.mokelab.demo.samcollection.model.article.ArticleDB

class JetpackRoomBasicViewModel(application: Application): AndroidViewModel(application) {
    val db = Room.databaseBuilder(application, ArticleDB::class.java, "article-db").build()
    val dao = db.articleDAO()
}