package com.example.quickwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwiki.adapters.RVArticleAdapter
import com.example.quickwiki.fragments.ArticleDB
import com.example.quickwiki.fragments.RVArticle

//class OfflineMode : AppCompatActivity() {
//
//    private lateinit var viewModel: ArticleViewModel
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_offline_mode)
//
//        val articleRV = findViewById<RecyclerView>(R.id.offlinemodeRV)
//        articleRV.layoutManager = LinearLayoutManager(this)
//        val article: ArrayList<RVArticle> = fetchArticleData(this)
//        article.add(RVArticle("url","title","content","url"))
//        val adapter = RVArticleAdapter(article)
//        articleRV.adapter = adapter
//        viewModel= ViewModelProvider(this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ArticleViewModel::class.java)
//        viewModel.allNotes.observe(this, { list ->
//            list?.let {
//                //check this out
//                //adapter.updateList(it)
//                //update rhe adapter list here
//            }
//        }
//        )
//    }
//}