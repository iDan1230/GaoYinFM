package com.bella.fm.framwork.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yzd on 2017/3/7.
 */

public class ViewUtils {


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
}
