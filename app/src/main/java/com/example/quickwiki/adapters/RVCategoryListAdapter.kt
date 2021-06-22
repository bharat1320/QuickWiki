package com.example.quickwiki.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwiki.R
import com.example.quickwiki.fragments.RVCategoryList

class RVCategoryListAdapter(private val item: ArrayList<RVCategoryList>): RecyclerView.Adapter<CategoryListViewHolder>() {
//class CategoryListRVAdapter(private val item: ArrayList<RVCategoryList>,private val listener : ListItemClicked): RecyclerView.Adapter<CategoryListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_categorylist, parent,false)
        /*  private val listener: NewsItemClicked
        view.setOnClickListener{
            listener.onItemClicked(item[CAtegoryListViewHolder.adapterPosition])
        }*/
        return CategoryListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.category.text = item[position].category
    }

    override fun getItemCount() = item.size
}

class CategoryListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var category: TextView = itemView.findViewById(R.id.RVCategoryListText)
}
//interface ListItemClicked{
//    fun onItemClicked(item: RVImage)
//}