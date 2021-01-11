package com.example.prsm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

/***************************************************************************************************
 * ++次にすること++
 * リストを押すと結果を表示する
 * ++++++++++++++
 *
 * PRSM2 -  MainActivity.kt
 *              fun ReadList
 *              fun ReadContent
 *          Result1Activity
 *          DataClass Content.kt
 *
 *          TabFragment.kt
 *          TabAdapter.kt
 *              fragment_tab_1
 *              fragment_tab_2
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
    }
}

//コンテンツ番号を渡すと、JSONからデーターを読み込んでContentクラスを返す。(コンテンツ番号,JSONBoject) リスト系
fun ReadList (n:String, b:JSONObject):Content{
    var postJSONObject = b.getJSONObject(n)
    var t : String = postJSONObject.getString("contentTitle")
    val s = postJSONObject.getJSONArray("contentSource")
    var ss = s.toString().drop(9).dropLast(1).split(",")//contentSourceを配列に
    var c : Content = Content(n,t,ss)
    return c
}
//コンテンツ番号を渡すと、JSONからデーターを読み込んでContentクラスを返す。(コンテンツ番号,JSONBoject)　コンテンツ系
fun ReadContent (n:String, b:JSONObject):Content{
    var postJSONObject = b.getJSONObject(n)
    var t : String = postJSONObject.getString("contentTitle")
    val s = postJSONObject.getJSONArray("contentSource")
    var ss = listOf<String>(s.toString()) //Listof(s.toString())//contentSourceを配列に
    var c : Content = Content(n,t,ss)
    return c
}