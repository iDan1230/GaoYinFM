package com.bella.fm.framwork.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bella.fm.App;
import com.bella.fm.framwork.utils.ToastUtil;


/**
 * Created by yzd on 2017/2/22.
 * 检查当前网络状态
 *
 * 广播中不能有耗时太多的操作，且不能再广播中开启一个子线程
 */

public class NetworkChangeReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context,"net",Toast.LENGTH_SHORT).show();
        //网络连接管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息对象
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isAvailable()){
////            ToastUtil.showToast("网络连接成功");
//            App.isNet = true;
//        }else {
//            App.isNet = false;
//            ToastUtil.showToast("当前处于无网络状态。。");
//        }
    }
}
