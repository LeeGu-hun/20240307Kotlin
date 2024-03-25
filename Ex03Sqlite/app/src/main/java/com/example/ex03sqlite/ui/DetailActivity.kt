package com.example.ex03sqlite.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex03sqlite.R
import com.example.ex03sqlite.util.getParcelable
import com.example.ex03sqlite.util.showNoti
import com.example.ex03sqlite.vo.MemberVO

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var vo: MemberVO? = null
        if (intent.hasExtra("member")) {
            vo = intent.getParcelable("member", MemberVO::class.java)
        }
        if (vo == null) {
            showNoti(this, "Null", "없는 데이터입니다.")
            return
        }
        Log.d(">>>", vo.toString())
    }
}
/*
https://yuuj.tistory.com/211

build.gradle (:app)에 아래 내용 추가

apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

androidExtensions {
    experimental = true
}

@Parcelize
data class User(
    val username: String,
    val thumbnail: String,
    val age: Int
) : Parcelable
전달하고싶은 데이터의 클래스에 @Parcelize 어노테이션을 달아준다.
*/
