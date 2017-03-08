package com.bella.fm;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.bella.fm.fm.fragment.CommunityFragment;
import com.bella.fm.fm.fragment.DiscoverFragment;
import com.bella.fm.fm.fragment.MineFragment;
import com.bella.fm.fm.fragment.SubScriberFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private int mImages[] = {R.drawable.tab_home, R.drawable.tab_consume, R.drawable.tab_aliance, R.drawable.tab_my};

    private Class mFragment[] = {DiscoverFragment.class,SubScriberFragment.class,CommunityFragment.class, MineFragment.class};

    private String mTextArray[] = {"首页", "善心消费", "联盟商家", "我的"};

    private LayoutInflater mLayoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabHost();
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
            tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
        }
    }
    //获取图片资源
    private View getImageView(int index) {
        View view = mLayoutInflater.inflate(R.layout.tab, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_tab);
        imageView.setImageResource(mImages[index]);
        return view;
    }
}
