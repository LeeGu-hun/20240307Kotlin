package com.example.ex06webview.util

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Parcelable
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog

fun showNoti(ctx: Context, title: String, msg: String) {
    AlertDialog.Builder(ctx).run {
        setTitle(title)
        setIcon(android.R.drawable.ic_dialog_info)
        setMessage(msg)
        setPositiveButton("OK", eventHandler)
        show()
    }
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

fun hideKeyboard(activity: Activity): Unit {
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(activity.window.decorView.applicationWindowToken, 0)
}

fun <T: Parcelable> Intent.getParcelable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelableExtra(key, clazz)
    } else {
        this.getParcelableExtra(key) as T?
    }
}
