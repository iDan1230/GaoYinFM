package com.bella.fm;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/2/7.
 */

public class App extends Application {

    private static App app;

    public static boolean isNet;//是否有网络
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化ok
        initOkhttp();
        //初始化facebook
        Fresco.initialize(this);
        //初始化友盟share
//        initShare();
    }
//    private void initShare() {
//        UMShareAPI.get(this);
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
//    }
    public static App getApplication() {
        return app;
    }
    public static Context getAppContext() {
        return app.getApplicationContext();
    }
    /**
     * 初始化okhttp
     */
    public void initOkhttp() {
//        File cacheFile = new File("/data/data/com/zpf/renrendai/cache",getCacheDir());
//        Cache cache = new Cache(getCacheDir(), 1024 * 1024 * 100); //100Mb
//        int cacheSize = 100 * 1024 * 1024;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .cache(cache)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

}
