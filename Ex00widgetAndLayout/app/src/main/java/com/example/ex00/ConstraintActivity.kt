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
            // 폰에서 전화에 대한 권한 설정을 해줘야 함.
            // 설정-애플리케이션-해당앱클릭-권한-전화를 추가할 것
            // permission 을 별도로 설정 해주려면 코드를 활용해야 함.
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
        binding.cb1.setOnCheckedChangeListener { cb, isChecked ->
            Toast.makeText(this, "${binding.cb1.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        binding.cb2.setOnCheckedChangeListener { cb, isChecked ->
            Toast.makeText(this, "${binding.cb1.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        binding.cb3.setOnCheckedChangeListener { cb, isChecked ->
            Toast.makeText(this, "${binding.cb1.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        binding.rb1.setOnCheckedChangeListener { rb, isChecked ->
            if (isChecked)
                Toast.makeText(this, "${binding.rb1.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        binding.rb2.setOnCheckedChangeListener { rb, isChecked ->
            if (isChecked)
                Toast.makeText(this, "${binding.rb2.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        binding.toggleButton.setOnCheckedChangeListener { tb, isChecked ->
            Toast.makeText(this, "${binding.toggleButton.text} $isChecked", Toast.LENGTH_SHORT)
                .show()
        }
        binding.switch1.setOnCheckedChangeListener { sw, isChecked ->
            Toast.makeText(this, "${binding.switch1.text} $isChecked", Toast.LENGTH_SHORT).show()
        }
        val textClock = binding.textClock
        // 익명 객체 사용 예
        textClock.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                Toast.makeText(this@ConstraintActivity, "${textClock.text}", Toast.LENGTH_SHORT)
                    .show()
                return true
            }
        })
        /*textClock.setOnLongClickListener {
            Toast.makeText(this@ConstraintActivity, "${textClock.text}", Toast.LENGTH_SHORT).show()
            true
        }*/
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






