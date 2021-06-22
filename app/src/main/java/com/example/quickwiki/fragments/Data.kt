package com.example.quickwiki.fragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class RVImage (
    var imageUrl: String,
    var user: String,
    var url: String
)

data class RVArticle (
    var imageUrl: String,
    var title: String,
    var content: String,
    var url: String
)

data class RVCategoryList(
    var category: String,
)

@Entity
data class ArticleDB(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name  = "imageUrl")val imageDB: String,
    @ColumnInfo(name  = "title")val titleDB: String,
    @ColumnInfo(name  = "content")val contentDB: String,
    @ColumnInfo(name  = "url")val urlDB: String)