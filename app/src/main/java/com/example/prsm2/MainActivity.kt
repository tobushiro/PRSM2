package com.example.prsm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

/***************************************************************************************************
 * PRSM2 -  MainActivity.kt
 *              fun readContent
 *          Result1Activity
 *          DataClass Content.kt
 *
 *          TabFragment.kt
 *          TabAdapter.kt
 *              fragment_tab_1
 *              fragment_tab_1
 *              
 *"9000000"のコンテンツを読み込む
 *
 *
 *
 *
 *
 *Github
 *  プロジェクトの登録:
 *  EnableVersionControlIntegration
 *  VCS > Import into version control > share project on GitHub
 *  変更の登録:
 *  VCS > commit
 *  VCS > Git > Push
 *ListViewを作る
 * https://joyplot.com/documents/2018/01/15/kotlin-listview-touch/
 *JSONを作る
 * https://codechacha.com/ja/how-to-use-assets-in-android/
 *
****************************************************************************************************
 */
/*
*contentNow :　現在表示しているコンテンツのクラス
*contentNext : タップされたコンテンツのクラス
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////Tabの実装
        pager.adapter = TabAdapter(supportFragmentManager,this)
        tab_layoutID.setupWithViewPager(pager)

        ////JSON関連
        val assetManager = resources.assets
        val inputStream = assetManager.open("maindata.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}
        val jObject = JSONObject(jsonString)

        //ListViewを作る*****************************************************************************
        ////"9000000"を読み込む
        var contentNow : Content = ReadContent("9000000", jObject)
        var contentNext : Content
        ////ListViewを表示する
        /*******************************************************************************************
        val listView = findViewById(R.id.listviewID) as ListView
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contentNow.contentSource)
        listView.adapter = adapter
        ///タップ処理
        listView.setOnItemClickListener {parent, view, position, id ->
            contentNext = ReadContent(contentNow.contentSource[position],jObject)
            when (contentNext.contentNumber.take(1)){//positonにしたらデバック
                "1" ->{
                    ///デバック用: 通常の結果に飛ぶ
                    var intent = Intent(this, Result1Activity::class.java)
                    startActivity(intent)
                }
                "9" -> {
                    //デバック用 :トースト
                    Toast.makeText(this,contentNext.contentSource.toString(),Toast.LENGTH_SHORT)
                        .show()
                }
                "0" -> {
                    //デバック用: 新しいリストを作る系
                    adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contentNext.contentSource)
                    listView.adapter = adapter
                    adapter.notifyDataSetChanged()
                    contentNow = contentNext
                }
                else ->{
                }
            }
        }
        *******************************************************************************************/
    }
}

//コンテンツ番号を渡すと、JSONからデーターを読み込んでContentクラスを返す。(コンテンツ番号,JSONBoject)
fun ReadContent (n:String, b:JSONObject):Content{
    var postJSONObject = b.getJSONObject(n)
    var t : String = postJSONObject.getString("contentTitle")
    val s = postJSONObject.getJSONArray("contentSource")
    var f = s.toString().drop(9).dropLast(1).split(",")//contentSourceを配列に
    var c : Content = Content(n,t,f)
    return c
}