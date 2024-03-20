package com.example.ex03sqlite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex03sqlite.R
import com.example.ex03sqlite.vo.MemberVO

class MemberAdapter : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    private var list: ArrayList<MemberVO> = ArrayList<MemberVO>()
    fun setList(list: ArrayList<MemberVO>): Unit {this.list = list}
    fun addMember(vo: MemberVO) {list.add(vo); notifyDataSetChanged()}
    fun setMember(position: Int, vo: MemberVO) {list.set(position, vo); notifyDataSetChanged()}
    fun getMember(position: Int): MemberVO {return list.get(position)}

    var handler: OnMemberItemClickHandler? = null
    fun setItemClickHandler(handler: OnMemberItemClickHandler){this.handler = handler}
    inner class MemberViewHolder(private val memberView: View) : RecyclerView.ViewHolder(memberView) {
        val tvId: TextView = memberView.findViewById(R.id.tvId)
        val tvName: TextView = memberView.findViewById(R.id.tvName)
        val tvAge: TextView = memberView.findViewById(R.id.tvAge)
        val tvMobile: TextView = memberView.findViewById(R.id.tvMobile)
        init {
            memberView.setOnClickListener { handler?.onItemClick(this, memberView, adapterPosition) }
        }
        fun setMember(vo: MemberVO): Unit {
            tvId.text = vo.id.toString();tvName.text = vo.name;tvAge.text = vo.age.toString()
            tvMobile.text = vo.mobile
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return MemberViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val memberVO = list.get(position)
        holder.setMember(memberVO)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}