package com.codeblogs.geeksforgeeks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codeblogs.geeksforgeeks.data.Item
import com.codeblogs.geeksforgeeks.data.Model
import com.codeblogs.geeksforgeeks.databinding.NewsFeedsBinding
import com.codeblogs.geeksforgeeks.databinding.SubFeedsBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var data = mutableListOf<Model>()
    lateinit var adapter: SubAdapter
    companion object{
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    @JvmName("setData1")
    fun setData(data: List<Model>) {
        this.data = data.toMutableList()
        notifyDataSetChanged()
    }
    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            return MainViewHolder(
                NewsFeedsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = data[position]
        holder.binding.tvDescription.text = data?.feed?.description
        holder.binding.tvDate.text = data?.items?.get(position)?.pubDate
        holder.binding.tvDescription.text = data?.feed?.title
        Glide.with(holder.itemView.context).load(data?.feed?.image).into(holder.binding.imageViewFeed)
        adapter = SubAdapter() // i do here bad practices
        holder.binding.recyclerview.adapter = adapter
        adapter.setData(data.items!!)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MainViewHolder(val binding: NewsFeedsBinding) : RecyclerView.ViewHolder(binding.root) {
}

/**
 * here i apply for multiview type
 * */

    class DownViewHolder(private val binding : SubFeedsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Item, itemView: View){
            Glide.with(itemView.context).load(data?.thumbnail).into(binding.image)
            binding.tvDate.text = data.pubDate
            binding.tvDescription.text = data.description
        }
    }
