package com.bella.fm;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bella.fm.fm.fragment.CommunityFragment;
import com.bella.fm.fm.fragment.DiscoverFragment;
import com.bella.fm.fm.fragment.MineFragment;
import com.bella.fm.fm.fragment.SubScriberFragment;
import com.bella.fm.framwork.base.BaseActivity;
import com.bella.fm.framwork.tools.AppManager;
import com.bella.fm.framwork.utils.ToastUtil;

public class MainActivity extends BaseActivity {

    private FragmentTabHost tabHost;
    private int mImages[] = {R.drawable.tab_discover, R.drawable.tab_subscriber, R.drawable.tab_community, R.drawable.tab_mine};

    private Class mFragment[] = {DiscoverFragment.class,SubScriberFragment.class,CommunityFragment.class, MineFragment.class};

    private String mTextArray[] = {"发现", "订阅", "社区", "我的"};

    private LayoutInflater mLayoutInflater;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        initTabHost();
    }

    @Override
    public void initData() {

    }

    private void initTabHost() {
        mLayoutInflater = LayoutInflater.from(this);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(),R.id.tabhostcontent);
        //去掉分割线
        tabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < mFragment.length; i++) {
            //对Tab按钮添加标记和图片
            // (两个参数缺一不可) newTabSpec(mTextArray[i]) tabhost内部是通过它来区别页面的
            // setIndicator(getImageView(i))：底部的选项
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(mTextArray[i]).setIndicator(getImageView(i));
            //添加Fragment
            tabHost.addTab(tabSpec, mFragment[i], null);
            //设置tab背景    tabHost.getTabWidget().getChildAt(i)：得到一个tab对象
            tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_bg);
            //设置tab高度
//            tabHost.getTabWidget().getChildAt(i).setMinimumHeight(200);
        }
    }
    //获取图片资源
    private View getImageView(int index) {
        View view = mLayoutInflater.inflate(R.layout.tab, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_tab);
        TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
        imageView.setImageResource(mImages[index]);
        tv_tab.setText(mTextArray[index]);
        return view;
    }


    private boolean exit;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if (!exit) {
                exit = true;
                handler.sendEmptyMessageDelayed(1, 2000);
                ToastUtil.showToast("再按一次退出");
            } else {
                AppManager.getInstance().AppExit(this);
            }
        }
        return false;
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            exit = false;
        }
    };



}
