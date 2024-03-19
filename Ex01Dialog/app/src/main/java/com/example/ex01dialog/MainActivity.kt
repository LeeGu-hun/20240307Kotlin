package com.example.ex01dialog

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.content.ContextCompat
import com.example.ex01dialog.databinding.ActivityMainBinding
import com.example.ex01dialog.databinding.ProgressBarBinding
import java.time.LocalDate
import java.time.LocalTime
import java.time.temporal.ChronoField
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
//    var handler: Handler? = null
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
                // 권한에 대해 PERMISSION_GRANTED 이면
                if (ContextCompat.checkSelfPermission(
                        this, "android.permission.POST_NOTIFICATIONS"
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    // android.permission.POST_NOTIFICATIONS의 권한 있으면 아래 호출
                    noti()
                } else {
                    // android.permission.POST_NOTIFICATIONS의 권한 없으면 아래 호출
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

        binding.btnCalendar.setOnClickListener {
            DatePickerDialog(
                this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "year: $year, month: $month, dayOfMonth: $dayOfMonth",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, LocalDate.now().year, LocalDate.now().get(ChronoField.MONTH_OF_YEAR) - 1,
                LocalDate.now().dayOfMonth
            ).show()
        }
        binding.btnTime.setOnClickListener {
            TimePickerDialog(
                this, object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(
                        view: TimePicker?,
                        hour: Int, minute: Int
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "$hour : $minute",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, LocalTime.now().hour, LocalTime.now().minute, true
            ).show()
        }
        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if (p1 == DialogInterface.BUTTON_POSITIVE) {
                    Log.d(">>", "BUTTON_POSITIVE")
                } else if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                    Log.d(">>", "BUTTON_NEGATIVE")
                } else {
                    Log.d(">>", "BUTTON_NEUTRAL")
                }
            }
        }
        binding.btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("Custom Dialog")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("커스텀 다이얼로그 창입니다. 닫으시겠어요?")
                setPositiveButton("OK", eventHandler)
                setNegativeButton("Cancel", eventHandler)
                setNeutralButton("More", eventHandler)
                show()
            }
        }

        binding.btnAlertList.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("Custom Dialog List")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(items, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(
                            this@MainActivity, "Your choice ${items[p1]}", Toast.LENGTH_SHORT
                        ).show()
                    }
                })
                setPositiveButton("OK", eventHandler)
                show()
            }
        }
        binding.btnAlertCheck.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("Custom Dialog List")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(items,
                    booleanArrayOf(true, false, true, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            p0: DialogInterface?, p1: Int,
                            p2: Boolean
                        ) {
                            Toast.makeText(
                                this@MainActivity,
                                " ${items[p1]}이 ${if (p2) "선택!" else "선택 해제!"}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                setPositiveButton("OK", eventHandler)
                show()
            }
        }
        binding.btnAlertRadio.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("Custom Dialog List")
                setIcon(android.R.drawable.ic_dialog_info)
                setSingleChoiceItems(items, 1,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(
                            p0: DialogInterface?, p1: Int
                        ) {
                            Toast.makeText(
                                this@MainActivity,
                                " ${items[p1]}이 선택!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                setPositiveButton("OK", eventHandler)
                show()
            }
        }

        binding.btnProgressWheel.setOnClickListener {
            val progressDialog = ProgressDialog(this, "wheel")
            progressDialog.show()
            thread {
                for (i in 1..3) {
                    SystemClock.sleep(1000 * 1)
                }
                if(progressDialog.isShowing) {
                    progressDialog.dismiss()
                }
            }
        }
        binding.btnProgressBar.setOnClickListener {
            val progressBar = ProgressDialog(this, "bar")
            val bindingProgress = ProgressBarBinding.inflate(layoutInflater)

            progressBar.show()
            thread {
                for (i in 1..100) {
                    runOnUiThread {
                        Log.d(">>", "$i  ${bindingProgress.progressBar.progress}")
                        progressBar.setPrg(i)
                    }
                    binding.progressBar2.progress = i
                    SystemClock.sleep(50)
                }
                if(progressBar.isShowing) {
                    progressBar.dismiss()
                }
            }
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







