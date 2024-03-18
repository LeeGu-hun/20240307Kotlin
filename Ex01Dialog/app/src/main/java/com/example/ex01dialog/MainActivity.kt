package com.example.ex01dialog

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.core.app.RemoteInput
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.ex01dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
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
        // ActivityResultLauncher는 사용자에게 퍼미션을 허용 요청할 때 사용
        // 위의 결과를 registerForActivityResult()를 호출해서 받을 수 있다.
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
            fun(it: Map<String, @JvmSuppressWildcards Boolean>) {
                if (it.all(fun(permission: Map.Entry<String, @JvmSuppressWildcards Boolean>): Boolean {
                        return permission.value == true
                    })) {
                    noti()
                    Toast.makeText(this, "permission granted...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        )
        binding.btnNotify.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        this, "android.permission.POST_NOTIFICATIONS"
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    noti()
                } else {
                    permissionLauncher.launch(
                        arrayOf("android.permission.POST_NOTIFICATIONS")
                    )
                }
            } else {
                noti()
            }
            Log.d(">>", "btnNotify")
        }

        binding.btnToast.setOnClickListener {
            Log.d(">>", "btnToast")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                showToast()
            }
            Toast.makeText(this, "Toast 알림", Toast.LENGTH_SHORT).show()
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun showToast(): Unit {
        //API 수준 28 Pie 다음부터 버전명은 Android10(API 29)으로 변경
        //Android11은 API 30, 여기부터 toast의 보여질때 사라질 때를 구분 할수 있음
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

    fun noti(): Unit {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                //채널에 대한 다양한 정보
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM).build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        builder.run {
            setSmallIcon(R.drawable.small)
            setWhen(System.currentTimeMillis())
            setContentTitle("알림왔어요")
            setContentText("안녕하세요")
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.big))
        }
        val KEY_TEXT_REPLY = "key_text_reply"
        val replyLabel = "Reply..."
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }
        val replyIntent = Intent(this, ReplyReceiver::class.java)
        val replyPendingIntent = PendingIntent.getBroadcast(
            this, 30, replyIntent, PendingIntent.FLAG_MUTABLE
        )
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.send, "Reply", replyPendingIntent
            ).addRemoteInput(remoteInput).build()
        )
        manager.notify(11, builder.build())
    }
}







