package com.bella.fm.fm.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bella.fm.R;
import com.bella.fm.framwork.base.BaseListAdpter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class DisListViewAdapter extends BaseListAdpter<String,DisListViewAdapter.ViewHolder> {

    private Context context;

    public DisListViewAdapter(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public int getResourceId(int position) {
        return R.layout.item_dis_listview;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.tv_top = findViewByIdNoCast(R.id)
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, String s, int position) {

    }

    @Override
    public void getAddressList(List<String> list) {

    }

    class ViewHolder extends BaseListAdpter.ViewHolder{
        private TextView tv_top;
    }
}
