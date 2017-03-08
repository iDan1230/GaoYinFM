package com.bella.fm.framwork.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bella.fm.R;

/**
 * Created by yzd on 2017/3/7.
 */

public class TopBar extends RelativeLayout{
    //左边
    private int leftBackColor;
    private int leftTextColor;
    private String leftTextInfo;
    //右边
    private int rightBackColor;
    private int rightTextColor;
    private String rightTextInfo;
    //title
    private int titleBackColor;
    private int titleTextColor;
    private String titleTextInfo;

    private Context context;
    private AttributeSet attrs;


    private Button leftButton;
    private Button rightButton;
    
    public TopBar(Context context) {
        
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    private void init() {
        leftButton = new Button(context);
        rightButton = new Button(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Toolbar);
        leftBackColor = typedArray.getColor(R.styleable.TopBar_leftBackColor,-1);
        leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,-1);
        leftTextInfo = typedArray.getString(R.styleable.TopBar_leftTextInfo);
        //释放
        typedArray.recycle();

        leftButton.setText(leftTextInfo);
        leftButton.setTextColor(leftTextColor);
        leftButton.setTag(this.ALIGN_PARENT_LEFT);


    }
}
