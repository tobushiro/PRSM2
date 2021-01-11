package com.example.prsm2

import org.json.JSONArray

/***************************************************************************************************
 *データクラス
 *contentNumber　9000000 :７桁の固有番号
 *contentTitle 植皮の厚さ : コンテンツのタイトル
 *contentSource 百澤　明, 分層植皮の適応と実際. PAPERS. 2: 19-24, 2005: 配列。 コンテンツの出典　又は次のリスト
 *
 ****************************************************************************************************
 */

data class Content(val contentNumber: String = "9000000",
                   val contentTitle : String = "コンテンツタイトル",
                   var contentSource: List<String>
)
