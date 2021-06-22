package com.example.quickwiki

import RVImageAdapter
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.quickwiki.adapters.RVCategoryListAdapter
import com.example.quickwiki.fragments.ArticleDB
import com.example.quickwiki.fragments.RVArticle
import com.example.quickwiki.fragments.RVCategoryList
import com.example.quickwiki.fragments.RVImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

//class ArticleViewModel(application: Application) : AndroidViewModel(application){
//    private val repository: ArticleRepository
//    val allNotes: LiveData<List<ArticleDB>>
//
//    init {
//        val dao = ArticleDatabase.getDatabase(application).getArticleDao()
//        repository = ArticleRepository(dao)
//        allNotes = repository.allNotes
//    }
//    fun deleteNote(article: ArticleDB) = viewModelScope.launch(Dispatchers.IO){
//        repository.delete(article)
//    }
//    fun insertNote(article: ArticleDB) = viewModelScope.launch(Dispatchers.IO){
//        repository.insert(article)
//    }
//
//}

fun fetchImageData(context: Context?): ArrayList<RVImage>
{
    val url = "https://commons.wikimedia.org/w/api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8"
    val dataSet = ArrayList<RVImage>()
    val jsonObjectRequest = JsonObjectRequest(
        Request.Method.GET,
        url,
        null, {
            val jsonObjectPages = it.getJSONObject("query").getJSONObject("pages") //this gives pages
            val values : Iterator<String> = jsonObjectPages.keys()
            var jsonObject: JSONObject
            for(key in values)
            {
                jsonObject = jsonObjectPages.getJSONObject(key).getJSONArray("imageinfo").getJSONObject(0)
                dataSet.add(RVImage(
                    jsonObject.getString("url"),
                    jsonObject.getString("user"),
                    jsonObject.getString("descriptionshorturl")
                ))
            }
            RVImageAdapter(dataSet).notifyDataSetChanged()
        }, {}
    )
    if (context != null) {
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)
    }
    return dataSet
}

fun fetchListData(context: Context?): ArrayList<RVCategoryList>
{
    val url = "https://en.wikipedia.org/w/api.php?action=query&list=allcategories&acprefix=List%20of&format=json"
    val dataSet2 = ArrayList<RVCategoryList>()
    val jsonObjectRequest = JsonObjectRequest(
        Request.Method.GET,
        url,
        null, {
            val jsonObject = it.getJSONObject("query")
            val jsonArray = jsonObject.getJSONArray("allcategories")
            var i = 0
            var string :String
            while(i < jsonArray.length())
            {
                string = jsonArray.getJSONObject(i).getString("*")
                dataSet2.add(RVCategoryList(
                    string
                ))
                i += 1
            }
            RVCategoryListAdapter(dataSet2).notifyDataSetChanged()
        }, {}
    )
    if (context != null) {
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)
    }
    else
        Toast.makeText(context, "we didnt got the context", Toast.LENGTH_SHORT).show()
    return dataSet2
}

fun fetchArticleData(context: Context?): ArrayList<RVArticle>
{
    val url = "https://en.wikipedia.org/w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=revisions|images&rvprop=content&grnlimit=10"

    //fetch data from api
    return ArrayList()
}

