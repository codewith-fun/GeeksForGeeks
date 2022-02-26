package com.codeblogs.geeksforgeeks.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codeblogs.geeksforgeeks.data.Model
import com.codeblogs.geeksforgeeks.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(private val mainRepository: MainRepository) :ViewModel() {
    private val TAG = "MainViewModel"
    val errorMessage = MutableLiveData<String>()
    val feedList = MutableLiveData<List<Model>>()
    val list = ArrayList<Model>()
    val loading = MutableLiveData<Boolean>()

    fun getAllFeeds(){
        CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = mainRepository.getTestFeeds()//getAllFeeds()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let { list.add(it) }
                    feedList.postValue(list)
                    loading.value = false
                    Log.i(TAG, "getAllFeeds:" +
                            " ${response.message()} and ${response.body().toString()}" +
                            " errorbody ${response.errorBody().toString()}")
                }else
                    Log.i(TAG, "getAllFeeds:" +
                            " ${response.message()} and ${response.body().toString()}" +
                            " errorbody ${response.errorBody().toString()}")
//                onError("Error :response.message()}")
            }
        }
    }

    private fun  onError(msg : String? ){
        errorMessage.value = msg
    }

}