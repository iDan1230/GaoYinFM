package com.bella.fm.framwork.share;

import android.content.Context;

/**
 * Created by yangzhidan on 2016/7/13 0013.
 * Description:
 */
public class SharePrefreceHelper extends PrefrenceWrapper {

    private static SharePrefreceHelper sharePrefreceHelper;


    private SharePrefreceHelper(Context context) {
        super(context);
    }


    public static SharePrefreceHelper getInstence(Context context) {
        if (sharePrefreceHelper == null)
            sharePrefreceHelper = new SharePrefreceHelper(context);
        return sharePrefreceHelper;
    }

//    public String getLati() {//纬度
//        return getString("lat");
//    }
//
//    public String getLong() {//经度度
//        return getString("long");
//    }
//
//    public void setLati(String latitude) {
//        putString("lat", latitude);
//    }
//
//    public void setLong(String longitude) {
//        putString("long", longitude);
//    }
//
//    public String getUid() {//用戶id
//        return getString("uid");
//    }
//
//    public void setUid(String uid) {
//        putString("uid", uid);
//    }
//
//    //登录时电话
//    public String getMobile() {//用戶id
//        return getString("mobile");
//    }
//
//    public void setMobile(String mobile) {
//        putString("mobile", mobile);
//    }
//
//
//    /**
//     * 当前使用或前一次支付成功时的联系电话（买）
//     *
//     * @return
//     */
//    public String getAddressMobile() {//用戶id
//        return getString("addressMobile");
//    }
//
//    public void setAddressMobile(String addressMobile) {
//        putString("addressMobile", addressMobile);
//    }
//
//    /**
//     * 当前使用或前一次支付成功时的地址Id
//     *
//     * @return
//     */
//    public String getAddressId() {//用戶id
//        return getString("addressId");
//    }
//
//    public void setAddressId(String addressId) {
//        putString("addressId", addressId);
//    }
//
//    /**
//     * 当前使用或前一次支付成功时的地址
//     *
//     * @return
//     */
//    public String getAddress() {//用戶id
//        return getString("address");
//    }
//
//    public void setAddress(String addressMobile) {
//        putString("address", addressMobile);
//    }
//
//    /**
//     * 当前使用或前一次支付成功时的地址
//     *
//     * @return
//     */
//    public String getAddress_info() {
//        return getString("address_info");
//    }
//
//    public void setAddress_info(String address_info) {
//        putString("address_info", address_info);
//    }
//
//    /**
//     * 收货人姓名
//     *
//     * @return
//     */
//    public String getName() {
//        return getString("s_name");
//    }
//
//    public void setName(String s_name) {
//        putString("s_name", s_name);
//    }
    /**
     * 通用
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return getStringValue(key);
    }

    public void setString(String key, String values) {
        putString(key, values);
    }

    public void putIsFirst(String key, boolean NickName){
        sharePrefreceHelper.setBoolean(key,NickName);

    }
    public  boolean getIsFrist(String key){
        return sharePrefreceHelper.getBoolean(key,false);
    }
}
