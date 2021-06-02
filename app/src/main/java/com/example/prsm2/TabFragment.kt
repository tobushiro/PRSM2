package com.example.prsm2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tab_1.*
import org.json.JSONObject
import com.example.prsm2.Result1Activity as Result1Activity

/*
 */
class Tab1Fragment(var key: String):Fragment() {                                             //リストを表示するフラグメント
    //Fragmentをinflateしている
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_1,container,false)
    }
    //リストを表示する
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ////ListViewの用意
        //JSONの用意
        val assetManager = resources.assets
        val inputStream = assetManager.open("maindata.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}
        val jObject = JSONObject(jsonString)
        //まず9000000のリストを読み込んでアダプターに渡す
        var contentNow : Content = ReadList(key, jObject)
        var items : ArrayList<String> = ItemsMake(contentNow.contentSource as ArrayList<String>,jObject)

        val adapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, items)
        this.listviewID.adapter = adapter
        //リストをタップした時の処理
        listviewID.setOnItemClickListener { parent, view, position, id ->
            when(position){
                in 0..9 -> {//デバック用に結果のactivityに
                    val intent = Intent(context, Result1Activity::class.java)
                    intent.putExtra("contentNumber",contentNow.contentSource[position])
                    startActivity(intent)
                }
                else -> {
                }
            }
        }
    }
}

class Tab2Fragment(var key:String):Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_2,container,false)
    }
}