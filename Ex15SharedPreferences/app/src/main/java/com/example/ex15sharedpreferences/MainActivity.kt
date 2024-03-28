package com.example.ex15sharedpreferences

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex15sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    /*private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
        val value1 = sharedPreference.getString("username", "데이터 없다1")
        val value2 = sharedPreference.getString("password", "데이터 없다2")
        Log.d("key-value", "username : " + value1)
        Log.d("key-value", "password : " + value2)
        binding.edUsername.text = Editable.Factory.getInstance().newEditable(value1)
        binding.edPassword.text = Editable.Factory.getInstance().newEditable(value2)

        binding.btnDelete.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()

            // editor.remove("password")
            editor.clear() // 전체 삭제
            editor.commit()
            finish()
        }
        binding.btnDelete.setOnClickListener {
            finish()
        }
    }
}