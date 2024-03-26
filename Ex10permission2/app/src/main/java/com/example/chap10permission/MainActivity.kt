package com.example.chap10permission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
            fun(it: Map<String, @JvmSuppressWildcards Boolean>) {
                if (it.all(fun(permission: Map.Entry<String, @JvmSuppressWildcards Boolean>): Boolean {
                        return permission.value == true
                    })) {
                    Toast.makeText(this, "permission granted...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "permission denied...", Toast.LENGTH_SHORT).show()
                }
            }
        )

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(
                this,
                "com.example.chap10.TEST_PERMISSION"
            )
            if (status == PackageManager.PERMISSION_GRANTED) {
                Log.d(">>", "Permission Granted")
            } else {
                Log.d(">>", "Permission Denied")
                permissionLauncher.launch(arrayOf("com.example.chap10.TEST_PERMISSION"))
            }
        }
    }
}