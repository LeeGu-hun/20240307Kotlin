package com.example.ex02recycler.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex02recycler.R
import com.example.ex02recycler.model.Affirmation

// data list를 RecyclerView에 주입하기 위한 클래스, RecyclerView.Adapter를 상속받는다.
class ItemAdapter(private val ctx: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = ctx.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        Log.d(">>", "${item.stringResourceId}")
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}












