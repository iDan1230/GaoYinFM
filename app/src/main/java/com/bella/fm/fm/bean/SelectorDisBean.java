package com.bella.fm.fm.bean;

/**
 * Created by yzd on 2017/3/8.
 * 发现叶 现象对象
 *
 */

public class SelectorDisBean {

    public int iconPath;
    public String iconName;

    public SelectorDisBean(int iconPath, String iconName) {
        this.iconPath = iconPath;
        this.iconName = iconName;
    }

    @Override
    public String toString() {
        return "SelectorDisBean{" +
                "iconPath=" + iconPath +
                ", iconName='" + iconName + '\'' +
                '}';
    }
}
