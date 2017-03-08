package com.bella.fm.framwork.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.bella.fm.App;


/**
 * Created by yangzhidan
 * description:
 */
public class ToastUtil {

    private static Toast toast = null;
    /**
     * 短时间显示Toast
     *
     * @param info 显示的内容
     */
    public static void showToast(String info) {

        if (StringUtils.isEmpty(info))
            return;
         Toast.makeText(App.getAppContext(), info, Toast.LENGTH_SHORT).show();

    }
    /**
     * 短时间显示Toast显示在中间
     *
     * @param info 显示的内容
     */
    public static void showCenterToast(String info) {

        if (StringUtils.isEmpty(info))
            return;
        Toast toast = Toast.makeText(App.getAppContext(), info, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }


    /**
     * 长时间显示Toast
     *
     * @param info 显示的内容
     */
    public static void showToastLong(String info) {
        Toast.makeText(App.getAppContext(), info, Toast.LENGTH_LONG).show();
    }

    /**
     * 短时间显示Toast
     */
    public static void showToast(int resId) {
        Toast.makeText(App.getAppContext(), App.getAppContext().getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     */
    public static void showToastLong(int resId) {
        Toast.makeText(App.getAppContext(), resId, Toast.LENGTH_LONG).show();
    }

}
