package com.bella.fm.framwork.base;

/**
 *  * author：yangzhidan on 2016/10/12 15:05
 *  * function: 积累Bean（根据接口修改一次）
 *  
 */
public class BaseBean{

   public String code;// 状态码
   public String msg;// 提示信息
   public String servertime;//请求数据时间


    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", servertime='" + servertime + '\'' +
                '}';
    }
}
