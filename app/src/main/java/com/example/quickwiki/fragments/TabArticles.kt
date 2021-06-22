package com.example.quickwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwiki.R
import com.example.quickwiki.adapters.RVArticleAdapter
import com.example.quickwiki.fetchArticleData


class TabArticles : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ArticleRV = view.findViewById<RecyclerView>(R.id.articleRV)
        ArticleRV.layoutManager = LinearLayoutManager(activity)

        val article: ArrayList<RVArticle> = fetchArticleData(activity)
        article.add(RVArticle("url","title","content","url"))

        ArticleRV.adapter = RVArticleAdapter(article)
    }
}