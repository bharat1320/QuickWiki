package com.example.quickwiki.fragments

import RVImageAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwiki.R
import com.example.quickwiki.fetchImageData

class TabFeaturedImages : Fragment() {
//class FeaturedImages : Fragment(),ImageClicked {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.tab_featured_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageRV = view.findViewById<RecyclerView>(R.id.imageRV)
        val data :ArrayList<RVImage> = fetchImageData(activity)
        data.add(RVImage("https://images-na.ssl-images-amazon.com/images/I/51iiSu3rkEL._SX331_BO1,204,203,200_.jpg","Demo Image","none"))
        imageRV.layoutManager = LinearLayoutManager(activity)
        imageRV.adapter =  RVImageAdapter(data)
        //imageRV.adapter =  ImageRVAdapter(data,this)
    }

//    override fun onItemClicked(item: RVImage){
//        val customTabsIntent = CustomTabsIntent.Builder().build()
//        activity?.let { customTabsIntent.launchUrl(it, Uri.parse(item.url)) }
//        Toast.makeText(activity, "mdf", Toast.LENGTH_SHORT).show()
//    }
}