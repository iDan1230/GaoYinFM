package com.bella.fm.framwork.http;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 网络请求数据
 *  
 */
public class HttpHelper {


    /**
     * 登录
     * name=>用户名或电话
     * pwd=>密码
     * usertype=>类型
     */
    public static void login(String name, String pwd, String usertype, StringCallback callback) {
//        if (!App.isNet) {
//            ToastUtil.showCenterToast("当前网络不可用");
//            return;
//        }
//        OkHttpUtils.post()
//                .url(PortString.LOGIN)
//                .addParams("name", name)
//                .addParams("pwd", pwd)
//                .addParams("usertype", usertype)
//                .build()
//                .execute(callback);
    }


}
