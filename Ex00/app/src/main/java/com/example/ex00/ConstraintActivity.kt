package com.example.ex00

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ConstraintActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        val btnMobile = findViewById<Button>(R.id.btnMobile)
        val btnImgClose = findViewById<ImageButton>(R.id.imageButtonClose)
        btnMobile.setOnClickListener {
            // 전화에 대한 권한 설정을 해줘야 함.
            // 설정-애플리케이션-해당앱클릭-권한-전화를 on
            // permission 을 별도로 설정해주려면 코드를 활용해야 함.
            val tel = btnMobile.text
            val uriPhoneNumber = Uri.parse("tel:" + tel)
            val intent = Intent(Intent.ACTION_CALL, uriPhoneNumber)
            startActivity(intent)
        }
        btnImgClose.setOnClickListener {
            finish()
        }
    }
}









