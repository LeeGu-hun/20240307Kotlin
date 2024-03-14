package com.example.ex00

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

class FrameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var imgs: Array<ImageView>
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPic1 -> visibleWithIndex(0)
            R.id.btnPic2 -> visibleWithIndex(1)
            R.id.btnPic3 -> visibleWithIndex(2)
        }
    }
    fun visibleWithIndex(idx: Int): Unit {
        for ((i, img) in imgs.withIndex()) {
            Log.d(">>", "$idx, $i, ${idx==i}")
            if(i==idx) img.visibility = View.VISIBLE
            else img.visibility = View.INVISIBLE
        }
    }
    /*@Composable
    fun Image(
        painter: Painter,
        contentDescription: String?,
        modifier: Modifier = Modifier,
        alignment: Alignment = Alignment.Center,
        contentScale: ContentScale = ContentScale.Fit,
        alpha: Float = DefaultAlpha,
        colorFilter: ColorFilter? = null
    )*/

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)
        imgs = arrayOf<ImageView>(
            findViewById<ImageView>(R.id.img1),
            findViewById<ImageView>(R.id.img2),
            findViewById<ImageView>(R.id.img3)
        )
        /*val img1 = findViewById<ImageView>(R.id.img1)
        val img2 = findViewById<ImageView>(R.id.img2)
        val img3 = findViewById<ImageView>(R.id.img3)*/

        val btn1 = findViewById<Button>(R.id.btnPic1)
        val btn2 = findViewById<Button>(R.id.btnPic2)
        val btn3 = findViewById<Button>(R.id.btnPic3)
        /*pic1.setOnClickListener{
            img1.visibility = View.VISIBLE
            img2.visibility = View.INVISIBLE
            img3.visibility = View.INVISIBLE
        }*/
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }
}