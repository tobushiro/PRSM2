package com.example.prsm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_result2.*

class Result2Activity : AppCompatActivity() {//CCR計算用
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)
    var c: Float = 1F

        val switch = findViewById<Switch>(R.id.switch1)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                c = 0.85F
            }else{
                c = 1F
            }
        }
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val a = (140 - editTextAge.text.toString().toInt())  *  editTextBW.text.toString().toInt()
            val b = 72 * editTextSCR.text.toString().toDouble()

            val ccr : Double = (a /b) * c
            textResult.text = ("%.2f".format(ccr))
        }
    }



}