package com.codeblogs.geeksforgeeks.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.codeblogs.geeksforgeeks.data.Model
import com.codeblogs.geeksforgeeks.databinding.NewsFeedsBinding
import com.codeblogs.geeksforgeeks.databinding.SubFeedsBinding

class NewsFeedAdapters : RecyclerView.Adapter<NewsFeedAdapters.MainViewHolder>() {
    var newsFedList = mutableListOf<Model?>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list:List<Model?>){
        newsFedList =list?.toMutableList()
        notifyDataSetChanged()
    }

    fun clear(){
        newsFedList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = NewsFeedsBinding.inflate(inflator,parent,false)
        return MainViewHolder(binding)
        /*
        when(viewType){

        }*/
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    val data = newsFedList[position]

    }

    override fun getItemCount(): Int {
        return if (newsFedList.isNotEmpty()){
            newsFedList.size
        }else{
            0
        }
    }
    class MainViewHolder( binding:ViewBinding) :RecyclerView.ViewHolder(binding.root){

    }

}

/**
 * I will do it after the metting
 * it would be as multiple view types
 * it would be seald class and also model class
 * */
//  class MainViewHolder( binding:ViewBinding) :RecyclerView.ViewHolder(binding.root) {

//     class MainViewHolder(private val binding: NewsFeedsBinding) :MainViewHolder(binding){
//        fun bind(title:Model){
//
//        }
//     }
//
//     class ListViewHolder(private val binding:SubFeedsBinding) :MainViewHolder(binding){
//
//     }


//}
