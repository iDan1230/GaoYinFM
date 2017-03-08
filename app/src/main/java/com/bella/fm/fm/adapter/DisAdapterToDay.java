package com.bella.fm.fm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bella.fm.R;
import com.bella.fm.fm.bean.DisTodayBean;
import com.bella.fm.fm.bean.SelectorDisBean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by yzd on 2017/3/8.
 */

public class DisAdapterToDay extends RecyclerView.Adapter<DisAdapterToDay.ViewHolder> {

    private Context context;

    private List<DisTodayBean> list;
    public DisAdapterToDay(Context context) {
        this.context = context;

    }

    public void setList(List<DisTodayBean> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_today,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item_dis_today_img.setImageResource(list.get(position).imgPath);
        holder.item_dis_today_tv_1.setText(list.get(position).tv_1);
        holder.item_dis_today_tv_2.setText(list.get(position).tv_2);
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView item_dis_today_img;
        private TextView item_dis_today_tv_1;
        private TextView item_dis_today_tv_2;

        public ViewHolder(View view) {
            super(view);
            item_dis_today_img = (ImageView) view.findViewById(R.id.item_dis_today_img);
            item_dis_today_tv_1 = (TextView) view.findViewById(R.id.item_dis_today_tv_1);
            item_dis_today_tv_2 = (TextView) view.findViewById(R.id.item_dis_today_tv_2);
        }
    }
}
