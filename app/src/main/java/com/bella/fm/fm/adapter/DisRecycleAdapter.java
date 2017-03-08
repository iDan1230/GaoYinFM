package com.bella.fm.fm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bella.fm.R;
import com.bella.fm.fm.bean.SelectorDisBean;

import java.util.List;

/**
 * Created by yzd on 2017/3/8.
 */

public class DisRecycleAdapter extends RecyclerView.Adapter<DisRecycleAdapter.ViewHolder> {

    private Context context;

    private List<SelectorDisBean> list;
    public DisRecycleAdapter(Context context) {
        this.context = context;

    }

    public void setList(List<SelectorDisBean> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_selector,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).iconPath);
        holder.textView.setText(list.get(position).iconName);

    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.item_dis_selecor_img);
            textView = (TextView) view.findViewById(R.id.item_dis_selector_tv);
        }
    }
}
