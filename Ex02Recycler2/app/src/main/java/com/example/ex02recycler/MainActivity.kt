package com.example.ex02recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex02recycler.adapter.ItemAdapter
import com.example.ex02recycler.data.Datasource
import com.example.ex02recycler.databinding.ActivityMainBinding

// https://developer.android.com/codelabs/basic-android-kotlin-training-display-list-cards?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3&hl=ko#0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)

        //1. data 불러오기
        val myDataset = Datasource().loadAffirmations()

        //2. RecyclerView initiate
        val recycler = binding.recycler

        //3. RecyclerView와 ItemAdapter 연결
        recycler.adapter = ItemAdapter(this, myDataset)
        recycler.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recycler.layoutManager = layoutManager

        binding.btnListH.setOnClickListener {
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            binding.recycler.layoutManager = layoutManager
        }
        binding.btnListV.setOnClickListener {
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            binding.recycler.layoutManager = layoutManager
        }
        binding.btnGrid.setOnClickListener {
            binding.recycler.layoutManager = GridLayoutManager(this, 2)
        }
//        binding.recycler.addItemDecoration(
//            DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
//        )
    }
}









