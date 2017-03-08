package com.bella.fm.framwork.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.bella.fm.framwork.utils.ToastUtil;


public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtil.showToast("自定义的广播");
    }
}
