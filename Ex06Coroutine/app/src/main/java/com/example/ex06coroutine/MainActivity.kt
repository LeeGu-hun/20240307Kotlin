package com.example.ex06coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex06coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var sum:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Android thread
        // https://everyday-develop-myself.tistory.com/185
        binding.button.setOnClickListener {
            // ANR 발생
            /*sum = 0L
            var time = measureTimeMillis {
                for (i in 1..2_000_000_000) {
                    sum += i
                }
            }
            Log.d(">>", "time: $time")
            binding.textView.text = "sum: $sum"*/
            val channel = Channel<Int>()
            // 백그라운드에서 동작
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            backgroundScope.launch {
                sum = 0L
                var time = measureTimeMillis {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                Log.d(">>", "time: $time")
                channel.send(sum.toInt())
            }
            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.textView.text = "sum: $sum"
                }
            }
        }
    }
}