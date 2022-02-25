package com.codeblogs.geeksforgeeks.repository

import android.util.Log
import com.codeblogs.geeksforgeeks.data.Model
import com.codeblogs.geeksforgeeks.interfaces.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository constructor(private val retrofitService: RetrofitService) {
    private val TAG = "MainRepository"
    suspend fun getAllFeeds() = retrofitService.getFeeds()
 /*   val call = retrofitService.getNewTestFeeds("http://www.abc.net.au/news/feed/51120/rss.xml")
    val result = call.enqueue(object :Callback<Model>{
        override fun onFailure(call: Call<Model>, t: Throwable) {
            Log.i(TAG, "onResponse: error ${t.message}")
        }

        override fun onResponse(call: Call<Model>, response: Response<Model>) {
            Log.i(TAG, "onResponse: ${response.body()}")
        }
    })
    suspend fun getNewTest() = result*/
    suspend fun  getTestFeeds() = retrofitService.getAllFeeds("http://www.abc.net.au/news/feed/51120/rss.xml")
}