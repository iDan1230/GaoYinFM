package com.bella.fm.framwork.db;

import java.io.Serializable;

/**
 *  * author：zipingfang on 2016/10/24 13:41
 *  * function: 登录用户Bean
 *  
 */

public class UserBean implements Serializable {

    public String userName;

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
