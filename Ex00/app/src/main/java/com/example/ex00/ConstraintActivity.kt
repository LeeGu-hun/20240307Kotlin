package com.example.ex00

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ex00.databinding.ActivityConstraintBinding
import com.example.ex00.databinding.ActivityMainBinding

class ConstraintActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewBinding을 활용하여 레이아웃 설정과 이벤트 처리
        val binding = ActivityConstraintBinding.inflate(layoutInflater)
        setContentView(binding.main)

        binding.btnMobile.setOnClickListener {
            // 전화에 대한 권한 설정을 해줘야 함.
            // 설정-애플리케이션-해당앱클릭-권한-전화를 on
            // permission 을 별도로 설정해주려면 코드를 활용해야 함.
            val tel = binding.btnMobile.text
            val uriPhoneNumber = Uri.parse("tel:" + tel)
            val intent = Intent(Intent.ACTION_CALL, uriPhoneNumber)
            startActivity(intent)
        }
        binding.imageButtonClose.setOnClickListener {
            finish()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        hideKeyboard(this@ConstraintActivity)
        return true
    }
}


fun hideKeyboard(activity: Activity): Unit {
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(activity.window.decorView.applicationWindowToken, 0)
}






