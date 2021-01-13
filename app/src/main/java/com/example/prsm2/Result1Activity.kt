package com.example.prsm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result1.*
import org.json.JSONObject

/*Result1Activity **********************************************************************************
*通常の結果を表示する
***************************************************************************************************/
class Result1Activity : AppCompatActivity() {

    private lateinit var mScaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)

        //ピンチズーム
        mScaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
        
        //JSONの準備
        val assetManager = resources.assets
        val inputStream = assetManager.open("maindata.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}
        val jObject = JSONObject(jsonString)
        var contentNumber = intent.getStringExtra("contentNumber")
        var contentNow = ReadContent(contentNumber, jObject)
        //画像の表示
        try {
            val viewID = resources.getIdentifier("pic${contentNow.contentNumber}", "drawable", packageName)
            result1_ivID.setImageResource(viewID)
        }catch (e:Exception){
        }
        //出典をトースト
        Toast.makeText(this, "出典: " + contentNow.contentSource.toString(), Toast.LENGTH_LONG).show()
        //アクションバーのタイトルを変更
        supportActionBar?.title = contentNow.contentTitle
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mScaleGestureDetector.onTouchEvent(event)
        return true//super.onTouchEvent(event)
    }

    //ピンチズーム
    private var mScaleFactor = 1.0f
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener(){
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            mScaleFactor *= mScaleGestureDetector.scaleFactor
            mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 5.0f))
            result1_ivID.scaleX = mScaleFactor
            result1_ivID.scaleY = mScaleFactor
            return true
        }
    }
}