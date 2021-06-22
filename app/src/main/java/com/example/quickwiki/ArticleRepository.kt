//package com.example.quickwiki
//
//import androidx.lifecycle.LiveData
//import com.example.quickwiki.fragments.ArticleDB
//
//class ArticleRepository(private val noteDao: ArticleDao) {
//
//    val allNotes: LiveData<List<ArticleDB>> = noteDao.getAllNotes()
//
//    suspend fun insert(article: ArticleDB){
//        noteDao.insert(article)
//    }
//
//    suspend fun delete(article: ArticleDB){
//        noteDao.delete(article)
//    }
//}