package com.example.ex00

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ex00.databinding.ActivityConstraintBinding

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
        binding.editId.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(this, "${binding!!.textView2.text}", Toast.LENGTH_SHORT).show()
                hideKeyboard(this@ConstraintActivity)
                return@OnKeyListener true
            }
            false
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            // rawX, rawY는 스크린, 즉 화면의 좌표값, x, y는 View안의 좌표값
            MotionEvent.ACTION_DOWN -> Log.d(">>", "Touch down x: ${event.x} , rawX: ${event.rawX}")
            MotionEvent.ACTION_UP -> Log.d(">>", "Touch up")
        }
        hideKeyboard(this@ConstraintActivity)
        return super.onTouchEvent(event)
    }
}


fun hideKeyboard(activity: Activity): Unit {
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(activity.window.decorView.applicationWindowToken, 0)
}






