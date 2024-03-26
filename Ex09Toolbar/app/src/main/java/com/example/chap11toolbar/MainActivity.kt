package com.example.chap11toolbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.chap11toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  @SuppressLint("MissingInflatedId")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setSupportActionBar(findViewById(R.id.toolbar))
    val frgMng: FragmentManager = supportFragmentManager
    val transaction: FragmentTransaction = frgMng.beginTransaction()
    val twoFrg: TwoFragment = TwoFragment()
    transaction.add(R.id.layout_for_twofrg, twoFrg)
    transaction.commit()
//    twoFrg.setTextV("hello hello")
    binding.button.setOnClickListener {
      val xx = binding.layoutForTwofrg?.get(R.id.frgtwotxt) as TextView
      Log.d(">>", xx.toString())
//      val frg2txt = frgMng?.findFragmentById(R.id.frgtwotxt) as TextView
//      frg2txt.text = ">> hello hello"
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    setTitle("Bar")
    menuInflater.inflate(R.menu.bar_menu, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menu1 -> {}
      R.id.menu2 -> {}
      R.id.menu3 -> {}
      else -> {}
    }
    return super.onOptionsItemSelected(item)
  }
}