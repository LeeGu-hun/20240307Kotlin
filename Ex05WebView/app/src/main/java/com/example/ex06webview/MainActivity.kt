package com.example.ex06webview

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex06webview.databinding.ActivityMainBinding
import com.example.ex06webview.util.hideKeyboard

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    /*private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //mBinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.webView.settings.apply {
            javaScriptEnabled = true; domStorageEnabled = true
            setSupportMultipleWindows(true)
        }
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("https://google.com")
        binding!!.editAddress.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                binding.webView.loadUrl(binding.editAddress.text.toString())
                hideKeyboard(this)
                return@OnKeyListener true
            }
            false
        })
        /*binding!!.editAddress.setOnKeyListener(View.OnKeyListener(fun(
            v: View,
            keyCode: Int,
            event: KeyEvent
        ): Boolean {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                hideKeyboard(this)
                return true
            }
            return false
        }))*/
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
    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            // 웹싸이트에서 뒤로 갈 페이지가 존재 할 경우
            binding.webView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}