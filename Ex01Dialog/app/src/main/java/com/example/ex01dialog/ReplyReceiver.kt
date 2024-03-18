package com.example.ex01dialog

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val replyText = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
        Log.d(">>", "replyText: $replyText")
        val manager = context?.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)
    }
}
