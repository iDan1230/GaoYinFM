package com.bella.fm.framwork.db.model;

import android.content.ContentValues;
import android.database.Cursor;


import com.bella.fm.framwork.base.BaseModel;
import com.bella.fm.framwork.db.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * test模板
 */
public class UserModel extends BaseModel {

    public static final String TABLE_NAME = "userinfo";//表名

    private static Map<String, String> paramsMap = new HashMap<>();

    static {
        paramsMap.put(_ID, "integer primary key autoincrement");//
        paramsMap.put("userName", "TEXT NOT NULL");//姓名
//        paramsMap.put("userid", "TEXT NOT NULL");//
    }

    /**
     * 插入一个用户
     * @param userBean
     */
    public void insertUser(UserBean userBean) {
        if (userBean == null)
            return;
        ContentValues values = new ContentValues();
//        values.put("userid", userBean.Data);
        values.put("userName", userBean.userName);
        insert(TABLE_NAME, values);

    }
    /**
     * 查询对象
     *
     * @param id
     * @return
     */
    public UserBean getUserBeanById(String id) {
        UserBean userBean = new UserBean();
        String sql = "select * from userinfo where userid=" + id;
        Cursor cursor = select(sql);
        if (cursor != null) {
            if (cursor.moveToNext()) {//找到userid为123的数据了
                userBean.userName = cursor.getString(cursor.getColumnIndex("name"));
//                userBean.Data = cursor.getString(cursor.getColumnIndex("userid"));
            }
        }
        return userBean;
    }

    /**
     * 查询全部对象
     * @return
     */
    public List<UserBean> getUserBeanList(){
        List<UserBean> list=new ArrayList<>();
        String sql="select * from userinfo";
        Cursor cursor=select(sql);
        if (cursor!=null){
            while (cursor.moveToNext()) {
                UserBean userBean=new UserBean();
//                userBean.Data = cursor.getString(cursor.getColumnIndex("userid"));
                userBean.userName = cursor.getString(cursor.getColumnIndex("userName"));
                list.add(userBean);
            }
        }
        return list;
    }
    /**
     * 查询最后的三条数据
     * @return
     */
    public List<UserBean> getUserBeanList3(){
        List<UserBean> list=new ArrayList<>();
        String sql="select * from userinfo order by "+_ID +" desc limit 3";
        Cursor cursor=select(sql);
        if (cursor!=null){
            while (cursor.moveToNext()) {
                UserBean userBean=new UserBean();
//                userBean.Data = cursor.getString(cursor.getColumnIndex("userid"));
                userBean.userName = cursor.getString(cursor.getColumnIndex("userName"));
                list.add(userBean);
            }
        }
        return list;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return paramsMap;
    }

    @Override
    public void clear(String tableName) {//清空表
        super.clear(tableName);
    }

    @Override
    public void delete(String tableName, String where, String[] whereArgs) {
        super.delete(tableName, where, whereArgs);
    }


    public void update(UserBean userBean, String where, String[] whereArgs) {
        if (userBean == null)
            return;
        ContentValues value = new ContentValues();
//        value.put("userid", userBean.Data);
        value.put("userName", userBean.userName);
        update(TABLE_NAME, value,where,whereArgs);
//        super.update(tableName, value, where, whereArgs);
    }
}
