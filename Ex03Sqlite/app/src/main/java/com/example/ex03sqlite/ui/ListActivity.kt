package com.example.ex03sqlite.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ex03sqlite.R
import com.example.ex03sqlite.adapter.MemberAdapter
import com.example.ex03sqlite.adapter.OnMemberItemClickHandler
import com.example.ex03sqlite.dao.DbSqlHandler
import com.example.ex03sqlite.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    // var binding: ActivityListBinding? = null
    lateinit var binding: ActivityListBinding
    lateinit var adapter: MemberAdapter
    lateinit var sqlHandler: DbSqlHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MemberAdapter()
        sqlHandler = DbSqlHandler.open(applicationContext)

        adapter.setList(sqlHandler.getList()) //adapter의 목록 초기화
        binding.recycler.adapter = adapter //recycler에 adapter 적용

        binding.recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        adapter.handler = object : OnMemberItemClickHandler {
            override fun onItemClick(holder: MemberAdapter.MemberViewHolder, v: View, idx: Int) {
                val vo = adapter.getMember(idx)
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra("member", vo)
                Log.d(">>>", "${holder.tvId.text}")
                Log.d(">>>", vo.toString())
                startActivity(intent)
            }
        }
    }
}








