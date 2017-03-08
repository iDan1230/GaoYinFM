package com.bella.fm.framwork.tools;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;


import com.bella.fm.framwork.utils.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;


/**
 * Created by Administrator on 2016/4/14.
 */
public class CommonFunction {
    Context context;

    public CommonFunction(Context context) {
        this.context = context;
    }

    final static String[] mFile = {
            "/data/data/com/qmgy/qmmall/cache",
            "/data/data/com/qmgy/qmmall/databases",
            "/data/data/com/qmgy/qmmall/files",
            "/mnt/sdcard/android/data/com/qmgy/qmmall/cache",
            "/storage/emulated/0/mmall"};

    /**
     * 计算缓存大小
     */
    public static String getAcacheSize(Context context) {

        try {

            double mAcacheSize =
                    DataCleanManager.getFolderSize(new File(mFile[0]))
                            + DataCleanManager.getFolderSize(new File(mFile[1]))
                            + DataCleanManager.getFolderSize(new File(mFile[2]))
                            + DataCleanManager.getFolderSize(new File(mFile[3]))
                            + DataCleanManager.getFolderSize(new File("/storage/emulated/0/qmgy"))
                            + DataCleanManager.getFolderSize(context.getCacheDir());
            return DataCleanManager.getFormatSize(mAcacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0M";
    }

    /**
     * 清空缓存
     */
    public static String clearAcache(Context context) {

        DataCleanManager.deleteFolderFile(mFile[0],
                true);
        DataCleanManager.deleteFolderFile(mFile[1],
                true);
        DataCleanManager.deleteFolderFile(mFile[2],
                true);
        DataCleanManager.deleteFolderFile(mFile[3],
                true);

        DataCleanManager.deleteFolderFile("/storage/emulated/0/renrendai",
                true);
        DataCleanManager.deleteFolderFile(context.getCacheDir().getAbsolutePath(),
                true);
//        try {

           return getAcacheSize(context);

//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }

    }

    public static void cleandate(Context context) {
        DataCleanManager.cleanApplicationData(context, mFile[0], mFile[1], mFile[2], mFile[3]);
    }

    /**
     * 用户协议
     *
     * @param context
     */
    public static void toUser(Activity context) {
//        UIController.toWebviewActivity(context,"/web/agree/Customer_app.html",R.string.copyright_agreement);


    }

    /**
     * @param view
     * @param oldColor 显示的颜色
     * @param newColor 按下的颜色
     */
    public static void setSelectorColor(final Context context, final View view, final int oldColor, final int newColor) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        view.setBackgroundColor(ContextCompat.getColor(context, newColor));
                        break;
                    case MotionEvent.ACTION_UP:
                        view.setBackgroundColor(ContextCompat.getColor(context, oldColor));
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        view.setBackgroundColor(ContextCompat.getColor(context, oldColor));
                        break;


                }
                return false;
            }
        });
    }

    /**
     * @param time 时间戳
     * @return
     */
    public static String getTime(long time, String format) {
        String strTime = "";
        long timeDiff = (System.currentTimeMillis() / 1000 - time);//秒
        if (timeDiff > 0) {
            if (timeDiff < 60) {
                strTime = "刚刚";
            } else if (timeDiff < 60 * 60) {
                strTime = (timeDiff / 60) + "分钟前";
            } else if (timeDiff < 60 * 60 * 24) {
                strTime = (timeDiff / 60 / 60) + "小时前";
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                strTime = dateFormat.format(time * 1000);
            }

        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            strTime = dateFormat.format(time * 1000);
        }

        return strTime;
    }

    /**
     * 是否已过期
     *
     * @param endTime
     * @return
     */
    public static boolean getOut(String endTime) {
        long time = System.currentTimeMillis() - (Long.parseLong(endTime) * 1000l);
        if (time > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 透明背景
     *
     * @param context
     * @param popupWindow
     */
    public static void setAlpha(final Context context, PopupWindow popupWindow) {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 0.5f;
        ((Activity) context).getWindow().setAttributes(lp);

        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        popupWindow.update();
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            //在dismiss中恢复透明度
            public void onDismiss() {
                WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
                lp.alpha = 1f;
                ((Activity) context).getWindow().setAttributes(lp);
            }
        });
    }

    public static String secondToMin(String second) {
        String time = "";
        if (!StringUtils.isEmpty(second)) {
            int s = Integer.parseInt(second);
            if (s > 60) {
                time = s / 60 + "'" + s % 60 + "''";
            } else {
                time = second + "''";
            }
        }
        return time;
    }

    /**
     * 显示键盘
     */
    public static boolean showSoft(Activity context) {
        InputMethodManager m = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        m.toggleSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0, InputMethodManager.SHOW_IMPLICIT);

//        m.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        return true;
    }

    /**
     * 隐藏键盘
     */
    public static boolean hideSoft(Activity context, View view) {
        ((InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE))

                .hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return true;
    }
}
