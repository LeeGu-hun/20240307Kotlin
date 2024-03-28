package com.example.ex15sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex06webview.util.hideKeyboard
import com.example.ex15sharedpreferences.databinding.ActivityLoginBinding

//[Android] Google Login 구현하기 with Kotlin 참조 사이트
//https://velog.io/@akimcse/Android-Google-Login-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with-Kotlin

//1. SharedPreferences란?
// 안드로이드 앱 개발을 진행하다 보면, 앱의 데이터들을 저장하여 관리해야 할 상황이 존재한다.
// 데이터의 양이 많거나 중요 데이터의 경우 서버나 DB에 저장해야겠지만,
// 간단한 설정 값이나 문자열 같은 데이터를 저장하기 위해 DB를 사용하기는 부담스럽기 때문에
// SharedPreferences를 사용하는 것이 적합하다.

//2. SharedPreferences의 특징
//보통 초기 설정값이나 자동 로그인 여부 등 간단한 값을 저장하기 위해 사용
//Application에 파일 형태로 데이터를 저장한다.
//Application이 삭제되기 전까지 저장한 데이터가 보존된다.
//Key-value 방식

//MODE의 종류
//MODE_PRIVATE : 생성한 Application에서만 사용 가능하다.
//MODE_WORLD_READABLE : 외부 App에서 사용 가능, But 읽기만 가능
//MODE_WORLD_WRITEABLE : 외부 App에서 사용 가능, 읽기/쓰기 가능

class LoginActivity : AppCompatActivity() {

    /*private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!*/
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)  //setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnDelete.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor  : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("username",binding.edUsername.text.toString())
            editor.putString("password",binding.edPassword.text.toString())

            editor.commit() // data 저장!

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }


    override fun onStart() {
        // Activity가 다시 나타날 때
        super.onStart()
        binding.edUsername.text = Editable.Factory.getInstance().newEditable("")
        binding.edPassword.text = Editable.Factory.getInstance().newEditable("")
        binding.edUsername.requestFocus()
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
