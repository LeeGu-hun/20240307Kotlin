package com.example.ex01dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager

class ProgressDialog(context: Context, flag: String) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        if (flag == "wheel") setContentView(R.layout.progress_wheel)
        else setContentView(R.layout.progress_bar)

        setCancelable(false)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // dialog의 dim 처리 배경 제거
        window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    fun setStopped(): Unit {
        setCancelable(true)
    }

}