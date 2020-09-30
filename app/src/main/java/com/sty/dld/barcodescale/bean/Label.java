package com.sty.dld.barcodescale.bean;

/**
 * 标签格式
 * @Author: tian
 * @UpdateDate: 2020/9/23 9:55 AM
 */
public class Label {
    private LabelBean labels;

    public LabelBean getLabels() {
        return labels;
    }

    public void setLabels(LabelBean labels) {
        this.labels = labels;
    }

    /**
     * "path": "/mnt/sdcard/mttest/LBL00101.xml"
     */
    public static class LabelBean {
        private String path; //标签文件的路径，该文件是由SmartLabel导出的

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
