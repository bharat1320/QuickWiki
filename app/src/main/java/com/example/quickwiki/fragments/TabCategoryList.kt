package com.example.quickwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwiki.*
import com.example.quickwiki.adapters.RVCategoryListAdapter


class TabCategoryList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.tab_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listRV = view.findViewById<RecyclerView>(R.id.listRV)
        listRV.layoutManager = LinearLayoutManager(activity)
        val rvcList: ArrayList<RVCategoryList> = fetchListData(activity)
        rvcList.add(RVCategoryList("List of Categories :- \n"))
        listRV.adapter = RVCategoryListAdapter(rvcList)
    }
}