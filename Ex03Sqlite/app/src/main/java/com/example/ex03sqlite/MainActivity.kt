package com.example.ex03sqlite

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex03sqlite.databinding.ActivityMainBinding
import com.example.ex03sqlite.ui.ListActivity
import com.example.ex03sqlite.ui.RegistActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnReg.setOnClickListener {
            val intent = Intent(applicationContext, RegistActivity::class.java)
            startActivity(intent)
        }
        binding.btnList.setOnClickListener {
            val intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        }
        binding.btnExit.setOnClickListener { finish() }
    }
}










