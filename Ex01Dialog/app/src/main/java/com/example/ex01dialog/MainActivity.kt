package com.example.ex01dialog

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex01dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        val btnToast = findViewById<Button>(R.id.btnToast)
        binding.btnToast.setOnClickListener {
            Log.d(">>", "btnToast")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                showToast()
            }
            Toast.makeText(this, "Toast 알림", Toast.LENGTH_SHORT).show()
        }
        binding.btnNotify.setOnClickListener {
            Log.d(">>", "btnNotify")
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun showToast(): Unit {
        val toast = Toast.makeText(this, "Toast Callback", Toast.LENGTH_SHORT)
        toast.addCallback(
            object : Toast.Callback() {
                override fun onToastShown() {
                    super.onToastShown()
                    Log.d(">>", "toast show")
                }

                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d(">>", "toast hidden")
                }
            }
        )
        toast.show()
    }
}







