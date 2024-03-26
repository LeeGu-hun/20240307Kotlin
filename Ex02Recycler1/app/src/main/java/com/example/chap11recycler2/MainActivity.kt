package com.example.chap11recycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.chap11recycler2.adapter.ItemAdapter
import com.example.chap11recycler2.data.Datasource

// https://soeun-87.tistory.com/24

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //1. data 불러오기
    val myDataset = Datasource().loadAffirmation()

    //2. RecyclerView 초기화
    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

    //3. RecyclerView와 ItemAdapter 연결
    recyclerView.adapter = ItemAdapter(this, myDataset)
    recyclerView.setHasFixedSize(true) //크기를 고정할 때 사용
  }
}