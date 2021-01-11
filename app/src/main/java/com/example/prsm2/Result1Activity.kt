package com.example.prsm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result1.*
import org.json.JSONObject

/*Result1Activity **********************************************************************************
*通常の結果を表示する
*
*
*        var picnumber : String = "pic${contentNumber.toString()}"
*        try {
            val viewID = resources.getIdentifier("pic${contentNumber.toString()}", "drawable", packageName)
            imageView1.setImageResource(viewID)
        }catch (e:Exception){
        *         //assetの準備(https://codechacha.com/ja/how-to-use-assets-in-android/)
        val assetManager = resources.assets
        val inputStream = assetManager.open("maindata.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}
        val jObject = JSONObject(jsonString)
***************************************************************************************************/
class Result1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)
        //JSONの準備
        val assetManager = resources.assets
        val inputStream = assetManager.open("maindata.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}
        val jObject = JSONObject(jsonString)

        var contentNumber = intent.getStringExtra("contentNumber")
        var contentNow = ReadContent(contentNumber, jObject)
        ra1TVID.text = contentNow.contentTitle
    }
}