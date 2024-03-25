package com.example.ex03sqlite.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ex03sqlite.dao.DbSqlHandler
import com.example.ex03sqlite.databinding.ActivityRegistBinding
import com.example.ex03sqlite.util.hideKeyboard
import com.example.ex03sqlite.util.showNoti
import com.example.ex03sqlite.vo.MemberVO

class RegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sqlHandler = DbSqlHandler.open(applicationContext)

        binding.btnReg.setOnClickListener {
            try {
                Log.d(">>","${binding.edAge.text.toString().toInt()}")
            } catch (e: NumberFormatException) {
                showNoti(this, "입력오류", "숫자만 입력하세요")
                binding.edAge.text = null
                binding.edAge.requestFocus()
                return@setOnClickListener
            }
            val vo = MemberVO(
                binding.edName.text.toString(),
                binding.edAge.text.toString().toInt(),
                binding.edMobile.text.toString()
            )
            var mid: Int = 0
            try {
                mid = sqlHandler.insert(vo).toInt()
            } catch (e: Exception) {
                showNoti(this,"실패","회원 등록이 실패하였습니다.")
                binding.edName.text = null
                binding.edAge.text = null
                binding.edMobile.text = null
                binding.edName.requestFocus()
                return@setOnClickListener
            }
            Log.d(">>", mid.toString())
            showNoti(this,"알림","$mid 번 회원이 등록되었습니다.")
            binding.edName.text = null
            binding.edAge.text = null
            binding.edMobile.text = null

//            finish()
//            val intent = Intent(applicationContext, ListActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//            startActivity(intent)
        }
        binding.btnList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnRegBack.setOnClickListener { finish() }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            // rawX, rawY는 스크린, 즉 화면의 좌표값, x, y는 View안의 좌표값
            MotionEvent.ACTION_DOWN -> Log.d(">>", "Touch down x: ${event.x} , rawX: ${event.rawX}")
            MotionEvent.ACTION_UP -> Log.d(">>", "Touch up")
        }
        hideKeyboard(this)
        return super.onTouchEvent(event)
    }


}


