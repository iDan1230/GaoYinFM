package com.bella.fm.framwork.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 基类ListView适配器
 *  
 */
public abstract class BaseListAdpter<T, VH extends BaseListAdpter.ViewHolder> extends BaseAdapter {

    private List<T> tList;

    private Context context;

    private View rootView;

    public BaseListAdpter(Context context) {
        this.context = context;
        tList=new ArrayList<>();
    }

    public BaseListAdpter(List<T> tList, Context context) {
        this.tList = tList;
        this.context = context;

    }

    public void settList(List<T> tList) {
        if (tList!=null){
            if (this.tList!=null){
                this.tList.clear();
                this.tList.addAll(tList);
            }

        }
//        this.tList = tList;
        getAddressList(tList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tList == null ? 0 : tList.size();
    }

    @Override
    public Object getItem(int i) {
        return tList == null ? null : tList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup viewGroup) {
        VH viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, getResourceId(postion), null);
            rootView = convertView;
            viewHolder = onCreateViewHolder(viewGroup,postion);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (VH) convertView.getTag();
        }

        T t = tList.get(postion);

        if (t != null)
            onBindViewHolder(viewHolder, t, postion);

        return convertView;
    }

    public abstract int getResourceId(int position);

    public abstract VH onCreateViewHolder(ViewGroup parent, int position);

    public abstract void onBindViewHolder(VH holder, T t, int position);

    public abstract void getAddressList(List<T> list);

    public class ViewHolder {

    }

    public <T extends View> T findViewByIdNoCast(int id){
        return (T) rootView.findViewById(id);
    }

}
