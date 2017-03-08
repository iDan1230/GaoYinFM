package com.bella.fm.framwork;


import android.os.Environment;


import com.bella.fm.framwork.db.model.UserModel;

import java.io.File;

/**
 * Description: 常量类
 */
public class Constants {

    //昵称
    public static  final String NICK_NAME ="quanmin";



    public static final String DB_NAME = "quanmin";//数据库名称

    public static final int DB_VERSION = 1;//数据库版本

    //数据库所有的表
    public static String[] TABLES = new String[]{UserModel.class.getName()};



    /**
     * 时区，日历写入的时候需要
     */
    public static final String TIME_ASIA = "Asia/Shanghai";
    /**
     * 提前多少分钟提醒，日历写入的时候需要
     */
    public static final int MINUTES = 1440;//默认提前一天

    /* 图片保存路径 */
    public static final String PHOTO_URI = "/ZPF/DEMOS/Image";

    /**
     * 用来标识请求照相功能的activity
     */
    public static final int CAMERA_WITH_DATA = 3021;
    /**
     * 用来标识请求相册的activity
     */
    public static final int PHOTO_PICKED_WITH_DATA = 3022;
    /**
     * 用跳转剪切
     */
    public static final int CROP_BIG_PICTURE = 3024;
    /**
     * 拍照的照片存储位置
     */
    public static final File PHOTO_DIR = new File(Environment.getExternalStorageDirectory() + Constants.PHOTO_URI);


    public static final String CITY ="city";
    public static final String LICATIONADDRESS ="lication_address";


    public static final String USER_NAME = "name";
    public static final String PASSWORD = "pwd";


//    /*
//     帮我买-购买地址requestCode
//     */
//    public static final int BUY_REQUESTCODE=0x1004;
//
//    /**
//     * 帮我买--购买商品
//     */
//    public static final int RELA_BUY_COMMODITY=0x1005;
//
//    /**
//     * 帮我买--选择地址(幫我送)
//     */
//    public static final int SELE_ADDRESS = 0x1006;
//
//    /**
//     * 帮我送——收件人
//     */
//    public static final int GIVE_RECIPIENTS = 0x1007;
//
//    /**
//     * 帮我送--物品图片
//     */
//    public static final int GIVE_PHOTO = 0x1008;
//
//    /**
//     * 帮我送--商品描述
//     */
//    public static final int GIVE_SHOP_CONTENT= 0x1009;
//
//    /**
//     * 帮我送--物品视频
//     */
//    public static final int GIVE_VIDEO = 0x1010;
//
//    /**
//     * 调用系统相机RequestCode
//     */
//    public static final int SYSTEM_VIDEO = 0x1011;
//
//    /**
//     * 我的目的地（帮帮我能送，我能买）
//     */
//    public static final int MY_DESTINATION = 0x1012;
//
//
//    /**
//     * 添加地址
//     */
//    public static final int ADD_ADDRESS = 0x1013;
//
//    /**
//     * 跳转登录页面
//     */
//    public static final int LOGIN = 0x1014;
//
//    /**
//     * 修改昵称
//     */
//    public static final int NEW_NAME = 0x1015;
//
//    /**
//     * 选择银行卡
//     */
//    public static final int SELE_KA = 0x1016;
//    /**
//     * 顺路订单end
//     */
//    public static final int SHUNLU = 0x1017;
//
//    /**
//     * 我的资料
//     */
//    public static final int MY_DATA = 0x1018;
//
//    /**
//     * request 百度
//     */
//    public static final int BAIDUMAP_PACKAGENAME = 0x1019;
//    /**
//     * request 高德
//     */
//    public static final int AMAP_PACKAGENAME = 0x1020;
//
//    /**
//     * 跳转到展示的页面
//     */
//    public static final int POHOTO_SHOW = 0x1021;
//    /**
//     * 跳转到相机
//     */
//    public static final int INTENT_CAMERA = 0x1022;
//    /**
//     * 跳转到相册
//     */
//    public static final int INTENT_PHOTO = 0x1023;
//    /**
//     * 图片裁剪
//     */
//    public static final int INTENT_CROP = 0x1024;
//    /**
//     * 跳转到相册
//     */
//    public static final int INTENT_PHOTO2 = 0x1025;
//
//    /**
//     * 纬度
//     */
//    public static final String LAT = "lat";
//    /**
//     * 经度
//     */
//    public static final String LONG="long";
//
//    /**
//     * 用户ID
//     */
//    public static final String UID="uid";
//
//    /**
//     * 用戶電話
//     */
//    public static final String MOBILE="mobile";
//    /**
//     * 用戶電話
//     */
//    public static final String MY_MOBILE="my_mobile";
//
//    /**
//     * 收貨（買）/發貨（送）地址電話
//     */
//    public static final String ADDRESS_MOBILE="addressMobile";
//
//    /**
//     * 收貨（買）/發貨（送）地址ID
//     */
//    public static final String ADDRESS_ID="addressId";
//
//    /**
//     * 收貨（買）/發貨（送）地址
//     */
//    public static final String ADDRESS="address";
//
//    /**
//     * 收貨（買）/發貨（送）詳細地址
//     */
//    public static final String ADDRESS_INFO="address_info";
//
//    /**
//     * 收貨人姓名
//     */
//    public static final String S_NAME="s_name";
//
//
//    /**
//     * 商品名称
//     */
//    public static final String COMM_NAME="comm_name";
//
//    /**
//     * 商品详情
//     */
//    public static  final String COMM_REMARK="comm_";
//
//    /**
//     * 商品价格
//     */
//    public static  final String COMM_PRICE="comm_price";
//


}
