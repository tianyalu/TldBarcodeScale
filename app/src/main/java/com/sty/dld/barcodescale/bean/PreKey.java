package com.sty.dld.barcodescale.bean;

import java.util.List;

/**
 * 预置键
 * @Author: tian
 * @UpdateDate: 2020/9/23 9:37 AM
 */
public class PreKey {
    /**
     * page : {"h":7,"w":10}
     * keys : [{"type":"PLU","location":[1,1,1],"dest":"60","title":""},{"type":"PLU","location":[1,5,2],"dest":"None(0)","title":""},{"type":"PLU","location":[2,3,6],"dest":"58","title":""}]
     */
    private PageBean page; //页面行列
    private List<KeysBean> keys;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<KeysBean> getKeys() {
        return keys;
    }

    public void setKeys(List<KeysBean> keys) {
        this.keys = keys;
    }

    public static class PageBean {
        /**
         * h : 7
         * w : 10
         */
        private int h; //页面行数，不填默认为7
        private int w; //页面列数，不填默认为10

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }

    public static class KeysBean {
        /**
         * type : PLU
         * location : [1,1,1]
         * dest : 60
         * title :
         */

        private String type = "PLU"; //类型填写"PLU
        private String dest; //设置的PLU号  填写"None(0)"可将该键位清空
        private String title; //忽略，可不填
        private List<Integer> location; //目标键位，三个值分别表示层数、行数、列数，层数只能是1或者2

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDest() {
            return dest;
        }

        public void setDest(String dest) {
            this.dest = dest;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Integer> getLocation() {
            return location;
        }

        public void setLocation(List<Integer> location) {
            this.location = location;
        }
    }
}
