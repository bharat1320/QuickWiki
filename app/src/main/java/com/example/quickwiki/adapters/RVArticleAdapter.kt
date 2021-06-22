package com.example.quickwiki.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickwiki.R
import com.example.quickwiki.fragments.RVArticle

class RVArticleAdapter (private val item: ArrayList<RVArticle>) : RecyclerView.Adapter<RVArticleHolder>(){
//class ArticleRVAdapter (private val item: ArrayList<RVArticle>,private val listener: ArticleClicked) : RecyclerView.Adapter<RVArticleHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVArticleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_article, parent, false)
//        view.setOnClickListener {
//            clickListener.onItemClicked(item[RVArticleHolder(view).adapterPosition])
//        }
        return RVArticleHolder(view)
    }

    override fun onBindViewHolder(holder: RVArticleHolder, position: Int) {
        Glide.with(holder.image.context).load(item[position].imageUrl).into(holder.image)
        holder.title.text = item[position].title
        holder.content.text = item[position].content
    }

    override fun getItemCount() = item.size

    fun updateList(newList: List<RVArticle>)
    {
        item.clear()
        item.addAll(newList)

        notifyDataSetChanged()
    }
}

class RVArticleHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var image: ImageView = itemView.findViewById(R.id.RVArticleImage)
    var title: TextView = itemView.findViewById(R.id.RVtitle)
    var content: TextView = itemView.findViewById(R.id.RVcontent)
}
//interface ArticleClicked{
//    fun onItemClicked(item: RVImage)
//}