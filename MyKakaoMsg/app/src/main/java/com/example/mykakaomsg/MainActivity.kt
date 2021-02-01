package com.example.mykakaomsg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kakao.sdk.common.util.KakaoCustomTabsClient
import com.kakao.sdk.link.LinkClient
import com.kakao.sdk.link.WebSharerClient
import com.kakao.sdk.talk.TalkApiClient
import com.kakao.sdk.template.model.DefaultTemplate

class MainActivity : AppCompatActivity() {
    private final var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent

        if (LinkClient.instance.isKakaoLinkAvailable(this)) {
            // 카카오톡으로 공유
            LinkClient.instance.scrapTemplate(this, "https://example.com/msgcallback") { linkResult, error ->
                if (error != null) {
                    Log.e(TAG, "카카오링크 실패", error)
                } else {
                    startActivity(linkResult!!.intent)
                }
            }
        } else {
            // 웹으로 공유
            WebSharerClient.instance.scrapTemplateUri(	"https://example.com/msgcallback").let {

                KakaoCustomTabsClient.openWithDefault(this, it)
                // 또는
                //startActivity(Intent(Intent.ACTION_VIEW, it))
            }
        }

//        val serverCallbackArgs = mapOf("templateId" to "46294")
//
//        val memo = LinkClient.instance.customTemplate(this, 46294, serverCallbackArgs) { linkResult, error ->
//            if (error != null) {
//                Log.e(TAG, "카카오링크 보내기 실패", error)
//            }
//            else if (linkResult != null) {
//                Log.d(TAG, "카카오링크 보내기 성공 ${linkResult.intent}")
//                startActivity(linkResult.intent)
//
//                // 카카오링크 보내기에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
//                Log.w(TAG, "Warning Msg: ${linkResult.warningMsg}")
//                Log.w(TAG, "Argument Msg: ${linkResult.argumentMsg}")
//            }
//        }
//
//        var button = findViewById(R.id.Button) as Button
//        button.setOnClickListener(View.OnClickListener {
//            Log.d(TAG, "clicked")
//            TalkApiClient.instance.sendDefaultMemo(memo) { error ->
//                if (error != null) {
//                    Log.e(TAG, "나에게 보내기 실패", error)
//                } else {
//                    Log.i(TAG, "나에게 보내기 성공")
//                }
//            }

//            LinkClient.instance.customTemplate(context = this, templateId = 46294) { linkResult, error ->
//                if (error != null) {
//                    Log.e(TAG, "카카오링크 보내기 실패", error)
//                }
//                else if (linkResult != null) {
//                    Log.d(TAG, "카카오링크 보내기 성공 ${linkResult.intent}")
//                    startActivity(linkResult.intent)
//
//                    // 카카오링크 보내기에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
//                    Log.w(TAG, "Warning Msg: ${linkResult.warningMsg}")
//                    Log.w(TAG, "Argument Msg: ${linkResult.argumentMsg}")
//                }
//            }
//        })
    }

}

private fun TalkApiClient.sendDefaultMemo(template: Unit, callback: (Throwable?) -> Unit) {

}
