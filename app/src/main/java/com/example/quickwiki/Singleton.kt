package com.example.quickwiki

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quickwiki.fragments.ArticleDB

class MySingleton constructor(context: Context){
    companion object{
        @Volatile
        private var INSTANCE: MySingleton? = null
        fun getInstance(context: Context) =
            INSTANCE ?: MySingleton(context).also{
                INSTANCE = it
            }
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
    fun<T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}

//@Database(entities = [ArticleDB::class], version = 1,exportSchema = false )
//abstract class ArticleDatabase: RoomDatabase(){
//    abstract fun getArticleDao(): ArticleDao
//
//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: ArticleDatabase? = null
//
//        fun getDatabase(context: Context): ArticleDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ArticleDatabase::class.java,
//                    "note_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
//}