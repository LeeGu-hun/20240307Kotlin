package com.example.ex00

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FrameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var imgs: Array<ImageView>
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.pic1 -> visibleWithIndex(0)
            R.id.pic2 -> visibleWithIndex(1)
            R.id.pic3 -> visibleWithIndex(2)
        }
    }
    fun visibleWithIndex(idx: Int): Unit {
        for ((i, img) in imgs.withIndex()) {
            Log.d(">>", "$idx, $i, ${idx==i}")
            if(i==idx) img.visibility = View.VISIBLE
            else img.visibility = View.INVISIBLE
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)
        imgs = arrayOf<ImageView>(
            findViewById<ImageView>(R.id.img1),
            findViewById<ImageView>(R.id.img2),
            findViewById<ImageView>(R.id.img3)
        )
        val img1 = findViewById<ImageView>(R.id.img1)
        val img2 = findViewById<ImageView>(R.id.img2)
        val img3 = findViewById<ImageView>(R.id.img3)

        val pic1 = findViewById<Button>(R.id.pic1)
        val pic2 = findViewById<Button>(R.id.pic2)
        val pic3 = findViewById<Button>(R.id.pic3)
        /*pic1.setOnClickListener{
            img1.visibility = View.VISIBLE
            img2.visibility = View.INVISIBLE
            img3.visibility = View.INVISIBLE
        }*/
        pic1.setOnClickListener(this)
        pic2.setOnClickListener(this)
        pic3.setOnClickListener(this)
    }
}