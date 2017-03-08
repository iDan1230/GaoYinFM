package com.bella.fm.framwork.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bella.fm.R;
import com.bella.fm.framwork.receiver.NetworkChangeReceiver;
import com.bella.fm.framwork.tools.AppManager;
import com.bella.fm.framwork.tools.SystemStatusManager;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

//import butterknife.ButterKnife;

/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 基类Activity
 *  
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            //被杀死之后重新创建
            getSaveData(savedInstanceState);
        }

//        /**
//         * 设置为横屏
//         */
//        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
        /**
         * 设置为竖屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(getContentViewId());
        ButterKnife.bind(this);
        //如果存在actionBar，就隐藏(也可以通过主题AppTheme.NoActionBar隐藏)
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        //将新建的activity添加到stack里进行管理
        AppManager.getInstance().addActivity(this);

        //设置状态栏透明
        setTranslucentStatus();
//        //改变状态栏颜色
//        setTitleBarColor(android.R.color.black);

        beforeInitView();
        initView();
        initData();
        //打印出，当前的活动页面名字
        Log.e("BaseActivity:", getClass().getSimpleName());
        checkNew();

    }

    private  IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    /**
     * 检查网络
     */
    public void checkNew(){

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //此处activity被杀死可以保存数据
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * 获取activity被杀死时候保存的数据
     *
     * @param savedInstanceState
     */
    public void getSaveData(Bundle savedInstanceState) {

    }

    @Override
    protected void onStop() {
        super.onStop();
//        Player.stop();
    }

    public abstract int getContentViewId();//放layoutId

    public abstract void beforeInitView();//初始化View之前做的事

    public abstract void initView();//初始化View

    public abstract void initData();//初始化数据

    /**
     * 状态栏透明只有Android 4.4 以上才支持
     */
    public void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(layoutParams);
        }
    }

    /**
     * 设置状态栏背景颜色
     */
    public void setTitleBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }

    /**
     * 不用强制转换的findviewbyid
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T findViewByIdNoCast(int id) {
        return (T) findViewById(id);
    }

   /* public void setOnClick(Object... objects) {

        for (Object object : objects) {
            if (object instanceof View) {
                ((View) object).setOnClickListener(this);
            }

            if (object instanceof Integer) {
                findViewById((Integer) object).setOnClickListener(this);
            }

        }
    }*/


    /**
     * 本段代码用来处理如果输入法还显示的话就消失掉输入键盘
     */
    protected void dismissSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    protected void showKeyboard(View view) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //    private Dialog dialog = null;
//    public void loadingAnim(){
//        cancelAnim();
//        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
//        View view = View.inflate(this, R.layout.dialog_loading,null);
//        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotation);
//        LinearInterpolator lin = new LinearInterpolator();
//        operatingAnim.setInterpolator(lin);
//        ImageView img = (ImageView) view.findViewById(R.id.img_loading);
//        img.startAnimation(operatingAnim);
//        dialog.setContentView(view);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
////        dialog.setContentView(view);
//        dialog.show();
//
//    }
    public void cancelLoading() {
        if (null != dialog && dialog.isShowing())
            dialog.dismiss();
        dialog = null;
    }

    private Dialog dialog = null;

//    public void startLoading() {
//        cancelLoading();
////        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
//        View view = View.inflate(this, R.layout.loding, null);
//        dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
//        dialog.setContentView(view);
//        ImageView iv_imageView = (ImageView) view.findViewById(R.id.img_loading);
//        AnimationDrawable animation = (AnimationDrawable) iv_imageView.getBackground();
//        animation.start();
//        dialog.show();
//    }

//    public void loadingAnim(){
//        cancelLoading();
//        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
//        View view = View.inflate(this, R.layout.dialog_loading,null);
//        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotation);
//        LinearInterpolator lin = new LinearInterpolator();
//        operatingAnim.setInterpolator(lin);
//        ImageView img = (ImageView) view.findViewById(R.id.img_loading);
//        img.startAnimation(operatingAnim);
//        dialog.setContentView(view);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
////        dialog.setContentView(view);
//        dialog.show();
//
//    }


    @Override
    protected void onDestroy() {
        AppManager.getInstance().remove(this);
        super.onDestroy();
        cancelLoading();
        unregisterReceiver(networkChangeReceiver);

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (this.getCurrentFocus() == null || this.getCurrentFocus().getWindowToken() == null) {
            return super.dispatchTouchEvent(event);
        }
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        return super.dispatchTouchEvent(event);
    }
}
