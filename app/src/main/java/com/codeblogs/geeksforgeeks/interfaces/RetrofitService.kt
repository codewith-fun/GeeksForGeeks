package com.codeblogs.geeksforgeeks.interfaces

import com.codeblogs.geeksforgeeks.data.Model
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {

    @GET("51120/rss.xml")
    suspend fun getFeeds() : Response<List<Model>>

    @GET("api.json")
    suspend fun getAllFeeds(@Query( "rss_url") query :String) : Response<Model>
    @GET("/api.json")
    fun getNewTestFeeds(@Query( "rss_url") query :String) : Call<Model>

//    @GET("/tasks")
//    fun getTasks(@Query("sort") order: String?): List<jdk.internal.org.jline.utils.ShutdownHooks.Task?>?

    companion object{
        val BASEURL = "https://api.rss2json.com/v1/"
//        val BASEURL = "https://api.rss2json.com/v1/api.json?rss_url=http://www.abc.net.au/news/feed/"
        var retrofitService : RetrofitService? = null
        fun getInstance(): RetrofitService{
            if (retrofitService ==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}