package com.example.firebaseauth

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.graphics.drawable.toDrawable

object CustomDialog {
    private var dialog: Dialog? = null

    @SuppressLint("InflateParams")
    fun showLoading(activity: Activity){
        val dialogView = activity.layoutInflater.inflate(R.layout.layout_progress, null, false)

        dialog = Dialog(activity)
        dialog?.setCancelable(false)
        dialog?.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        dialog?.setContentView(dialogView)

        dialog?.show()
    }

    fun hideLoading(){
        dialog?.dismiss()
    }
}