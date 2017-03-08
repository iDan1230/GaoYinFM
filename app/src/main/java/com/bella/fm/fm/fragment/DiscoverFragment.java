package com.bella.fm.fm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bella.fm.R;
import com.bella.fm.fm.adapter.DisAdapterToDay;
import com.bella.fm.fm.adapter.DisRecycleAdapter;
import com.bella.fm.fm.adapter.DisRecycleAdapter;
import com.bella.fm.fm.bean.DisTodayBean;
import com.bella.fm.fm.bean.SelectorDisBean;
import com.bella.fm.framwork.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 */
public class DiscoverFragment extends BaseFragment {
    //类型选项
    private List<SelectorDisBean> selectorDisBeens;
    private DisRecycleAdapter disAdapter_1;
    private RecyclerView selector_recycler;

    //今日必听
    private List<DisTodayBean> disTodayBeens;
    private DisAdapterToDay disAdapterToDay;
    private RecyclerView today_recycler;

    @Override
    protected int getResource() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void beforeInitView() {


    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {
        disAdapter_1();
        disToDay();
    }

    //类型选项
    private void disAdapter_1(){
        //假数据
        selectorDisBeens = new ArrayList<>();
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_jindian, "经典必听"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_haowen, "深度好文"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_zhiyu, "情感治愈"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_xiaoshuo, "热门小说"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_jindian, "经典必听"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_haowen, "深度好文"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_zhiyu, "情感治愈"));
        selectorDisBeens.add(new SelectorDisBean(R.mipmap.selector_xiaoshuo, "热门小说"));
        disAdapter_1 = new DisRecycleAdapter(getContext());
        disAdapter_1.setList(selectorDisBeens);
        selector_recycler = findViewByIdNoCast(R.id.dis_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        selector_recycler.setLayoutManager(linearLayoutManager);
        selector_recycler.setAdapter(disAdapter_1);
    }

    //今日必听
    private void disToDay(){
        disTodayBeens = new ArrayList<>();
        disTodayBeens.add(new DisTodayBean(R.mipmap.todayimg_1,"乐嘉识人","乐嘉幸福色彩-红黄蓝绿钻石法则"));
        disTodayBeens.add(new DisTodayBean(R.mipmap.todayimg_2,"十点读书","穷到极致是一种怎样体验"));
        disTodayBeens.add(new DisTodayBean(R.mipmap.todayimg_3,"龙猫","人人心中都有龙猫童年就不会消失"));

        disAdapterToDay = new DisAdapterToDay(getContext());
        disAdapterToDay.setList(disTodayBeens);
        today_recycler = findViewByIdNoCast(R.id.dis_recycler_today);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        today_recycler.setLayoutManager(linearLayoutManager);
        today_recycler.setAdapter(disAdapterToDay);
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("msg", "DiscoverFragment");
    }

    @Override
    public void onClick(View view) {

    }
}
