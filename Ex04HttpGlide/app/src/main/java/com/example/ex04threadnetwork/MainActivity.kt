package com.example.ex04threadnetwork

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex04threadnetwork.databinding.ActivityMainBinding
import com.example.ex04threadnetwork.databinding.ItemMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var volleyFrag: VolleyFragment
    lateinit var retorfitFrag: RetrofitFragment
    var mode = "volley"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        volleyFrag = VolleyFragment()
        retorfitFrag = RetrofitFragment()

        supportFragmentManager.beginTransaction().replace(R.id.activity_content, volleyFrag)
            .commit()
        supportActionBar?.title = "Volley Test"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.menu_volley && mode !== "volley") {
            supportFragmentManager.beginTransaction().replace(R.id.activity_content, volleyFrag)
                .commit()
            mode = "volley"
            supportActionBar?.title = "volley Test"
        } else if (item.itemId === R.id.menu_retrofit && mode !== "retrofit") {
            supportFragmentManager.beginTransaction().replace(R.id.activity_content, retorfitFrag)
                .commit()
            mode = "retrofit"
            supportActionBar?.title = "Retrofit Test"
        }
        return super.onOptionsItemSelected(item)
    }
}








