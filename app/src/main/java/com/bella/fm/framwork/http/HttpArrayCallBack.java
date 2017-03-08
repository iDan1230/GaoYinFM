package com.bella.fm.framwork.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bella.fm.framwork.base.BaseBean;
import com.bella.fm.framwork.utils.LogUtils;
import com.bella.fm.framwork.utils.StringUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import okhttp3.Call;

/**
 *  * author：zipingfang on 2016/10/24 13:22
 *  * function: 数据解析接口
 *  
 */

public abstract class HttpArrayCallBack<T> extends StringCallback {


    private Class<T> tClass;

    public HttpArrayCallBack() {
        tClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /*
    * 200  正常返回
    * 400  参数错误
    * 401  请求验证错误
    * 403  无权限操作
    * 404  无此文件接口
    * 406  同时操作文件太多
    * 413  文件太大
    * 420  验证码不存在
    * 500  服务器内部错误
    * 1001 验证码已使用或者已过期

     */

    @Override
    public void onError(Call call, Exception e, int id) {
        isFail("数据请求失败，请稍后再试");
    }

    @Override
    public void onResponse(String response, int id) {

        if (StringUtils.isNotEmpty(response)) {

            try {
                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
                LogUtils.e("msg", response);
                if (baseBean.code.equals("200")&&baseBean.msg != null) {
                    LogUtils.e("msg", "baseBean200:" + baseBean.toString() + response);
//                    isSucceed(JSON.parseArray(baseBean.data, tClass));
                } else{
//                    isFail(baseBean.error);
                }
            } catch (JSONException e) {
                isFail("请求异常");
            }

        } else {
            isFail("服务器无返回信息");
        }

    }


    public abstract void isFail(String failContent);

    public abstract void isSucceed(List<T> result);
}
