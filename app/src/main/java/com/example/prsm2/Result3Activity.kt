package com.example.prsm2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Result3Activity : AppCompatActivity() {//メーラー起動
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result3)

    //メールアプリ
    val mintent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:")//メールアプリのみで処理したい時に記述
        val subject = "${getString(R.string.app_name)}から送信します"
        val text = "本文です。"
        putExtra(Intent.EXTRA_EMAIL, arrayOf( "tobushiro@gmail.com" ))//第二引数はArrayにしないと入力されないので注意
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT,text)
    }
    if(mintent.resolveActivity(packageManager)!=null) {//インテントを処理できるアプリが存在するか確認
        startActivity(mintent)//処理するアプリがいないのにstartActivityするとアプリが強制終了するので注意
    }
    }
}