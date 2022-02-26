package com.codeblogs.geeksforgeeks.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeblogs.geeksforgeeks.data.Item
import com.codeblogs.geeksforgeeks.databinding.SubFeedsBinding

class SubAdapter:RecyclerView.Adapter<DownViewHolder>() {
    var data = mutableListOf<Item>()

    @JvmName("setData1")
    fun setData(data :List<Item>){
        this.data = data.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownViewHolder {
        return DownViewHolder(SubFeedsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: DownViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,holder.itemView)
    }

    override fun getItemCount(): Int {
    return data.size
    }
}