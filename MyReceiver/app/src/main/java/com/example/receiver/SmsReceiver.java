package com.example.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive 호출");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages != null && messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();
            String contents = messages[0].getMessageBody();
            Log.d(TAG, sender + " | " + contents);

            sendToActivity(context, sender, contents);
        }
    }

    public void sendToActivity(Context con, String sen, String content) {
        Intent intent = new Intent(con, SmsActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK | // 화면이 없는 상태에서는 새로 띄움
                intent.FLAG_ACTIVITY_SINGLE_TOP |  intent.FLAG_ACTIVITY_CLEAR_TOP); // 화면 있으면 이걸 Top에 띄움
        intent.putExtra("sender", sen);
        intent.putExtra("contents", content);

        con.startActivity(intent);

    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        int smsCount =objs.length;
        for(int i=0; i<smsCount; i++) {
            // 버전에 따라 다르게 동작하도록
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i], format);

            }
            else {
                SmsMessage.createFromPdu((byte[])objs[i]);
            }
        }
        return messages;
    }
}