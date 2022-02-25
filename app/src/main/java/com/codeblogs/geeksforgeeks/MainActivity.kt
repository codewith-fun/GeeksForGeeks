package com.codeblogs.geeksforgeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.codeblogs.geeksforgeeks.adapters.NewsFeedAdapters
import com.codeblogs.geeksforgeeks.data.Model
import com.codeblogs.geeksforgeeks.databinding.ActivityMainBinding
import com.codeblogs.geeksforgeeks.interfaces.RetrofitService
import com.codeblogs.geeksforgeeks.repository.MainRepository
import com.codeblogs.geeksforgeeks.viewmodels.MainViewModel
import com.codeblogs.geeksforgeeks.viewmodels.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var  adapter : NewsFeedAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        adapter = NewsFeedAdapters()
        viewModel = ViewModelProvider(this,MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)
        viewModel.feedList.observe(this,{

            binding.recyclerview.adapter = adapter
            adapter.setData(listOf(it))


        })
        viewModel.errorMessage.observe(this,{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.loading.observe(this,{
            if (it){
                binding.progressDialog.visibility = View.VISIBLE
            }else{
                binding.progressDialog.visibility = View.GONE
            }
        })
        viewModel.getAllFeeds()

        binding.swipetorefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light);

        binding.swipetorefresh.setOnRefreshListener {
//            adapter.clear()
            viewModel.getAllFeeds()
            binding.swipetorefresh.setRefreshing(false)
        }
    }
}