package com.example.ex04threadnetwork.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ex04threadnetwork.databinding.ItemMainBinding
import com.example.ex04threadnetwork.model.ItemModel
class MyViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
class MyAdapter(val ctx: Context, val datas: MutableList<ItemModel>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return datas?.size ?: 0  // ?: 왼쪽값이 널이 아니면 값, 널이면 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        val model = datas!![position]
        binding.itemTitle.text = model.title
        binding.itemDesc.text = model.description
        binding.itemTime.text = "${model.author} At ${model.publishedAt}"
        Glide.with(ctx).load(model.urlToImage).into(binding.itemImage)
    }
}









