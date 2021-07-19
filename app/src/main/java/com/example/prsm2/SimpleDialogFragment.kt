package com.example.prsm2

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SimpleDialogFragment:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("＜はじめに＞")
            .setMessage("このアプリ利用の結果生じた損害について、一切責任を負いません。利用者はこのアプリの医学的内容または著作権に問題を感じた場合、作成者に連絡してください。")
            .setPositiveButton("理解して同意した"){dialog, id ->
                Toast.makeText(context, "ありがとうございます！", Toast.LENGTH_SHORT).show()
            }
        this?.setCancelable(false)
        return builder.create()
    }
}