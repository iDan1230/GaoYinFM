package com.bella.fm.fm.bean;

/**
 * Created by yzd on 2017/3/8.
 */

public class DisTodayBean {

    public int imgPath;
    public String tv_1;
    public String tv_2;

    public DisTodayBean(int imgPath, String tv_1, String tv_2) {
        this.imgPath = imgPath;
        this.tv_1 = tv_1;
        this.tv_2 = tv_2;
    }

    @Override
    public String toString() {
        return "DisTodayBean{" +
                "imgPath=" + imgPath +
                ", tv_1='" + tv_1 + '\'' +
                ", tv_2='" + tv_2 + '\'' +
                '}';
    }
}
