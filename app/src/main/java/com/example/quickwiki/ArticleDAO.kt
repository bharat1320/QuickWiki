//package com.example.quickwiki
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import com.example.quickwiki.fragments.ArticleDB
//
//@Dao
//interface ArticleDao {
//
//    @Query("SELECT * FROM ArticleDB ORDER BY id ASC")
//    fun getAllNotes(): LiveData<List<ArticleDB>>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(vararg article: ArticleDB)
//
//    @Delete
//    suspend fun delete(article: ArticleDB)
//
//}