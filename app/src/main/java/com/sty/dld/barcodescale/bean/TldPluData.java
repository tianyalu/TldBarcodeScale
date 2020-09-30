package com.sty.dld.barcodescale.bean;

import java.util.List;

/**
 * 商品信息
 * @Author: tian
 * @UpdateDate: 2020/9/23 9:13 AM
 */
public class TldPluData {
    /**
     * plu : 1
     * descriptions : ["2级牛肉"]
     * priceA : {"value":88.68,"uom":"PCS","unitDes":"包","discount":false,"override":false,"type":"BasePrice"}
     * department : 1
     * group : 1
     * categories : ["0"]
     * tare : {"value":2,"uom":"KGM"}
     * packed : {"value":"2014-09-03","unit":"date","printable":true}
     * bestBefore : {"value":"1","unit":"day","printable":true}
     * sellBy : {"value":"2","unit":"day","printable":true}
     * barcode : 12
     * labels : [1,2,3]
     * et1 : 牛肉
     * et2 : 蛋白质
     * et3 : 脂肪
     * et4 : 水
     * et5 : 铁
     * et6 : 金坛雀舌
     * et7 : 溧阳白茶
     * et8 : 毛尖
     */

    private String plu;  //PLU号
    private PriceABean priceA;  //单价，只支持第一单价
    private String department;  //部门号
    private String group;  //分组号
    private TareBean tare;  //皮重
    private PackedBean packed;  //包装
    private BestBeforeBean bestBefore;  //推荐日期
    private SellByBean sellBy;  //保质日期
    private int barcode;  //条码号
    private String et1;  //附加文本用于配料表、产地等附加信息。附加文本段落1
    private String et2;  //附加文本段落2
    private String et3;  //附加文本段落3
    private String et4;  //附加文本段落4
    private String et5;  //附加文本段落5
    private String et6;  //附加文本段落6
    private String et7;  //附加文本段落7
    private String et8;  //附加文本段落8
    private List<String> descriptions;  //商品名称，只会解析JSONArray中的第一个元素
    private List<String> categories;  //分类号，最多填写5个，一般只用1个
    private List<Integer> labels;  // 标签号，一般只填一个值

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public PriceABean getPriceA() {
        return priceA;
    }

    public void setPriceA(PriceABean priceA) {
        this.priceA = priceA;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public TareBean getTare() {
        return tare;
    }

    public void setTare(TareBean tare) {
        this.tare = tare;
    }

    public PackedBean getPacked() {
        return packed;
    }

    public void setPacked(PackedBean packed) {
        this.packed = packed;
    }

    public BestBeforeBean getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(BestBeforeBean bestBefore) {
        this.bestBefore = bestBefore;
    }

    public SellByBean getSellBy() {
        return sellBy;
    }

    public void setSellBy(SellByBean sellBy) {
        this.sellBy = sellBy;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getEt1() {
        return et1;
    }

    public void setEt1(String et1) {
        this.et1 = et1;
    }

    public String getEt2() {
        return et2;
    }

    public void setEt2(String et2) {
        this.et2 = et2;
    }

    public String getEt3() {
        return et3;
    }

    public void setEt3(String et3) {
        this.et3 = et3;
    }

    public String getEt4() {
        return et4;
    }

    public void setEt4(String et4) {
        this.et4 = et4;
    }

    public String getEt5() {
        return et5;
    }

    public void setEt5(String et5) {
        this.et5 = et5;
    }

    public String getEt6() {
        return et6;
    }

    public void setEt6(String et6) {
        this.et6 = et6;
    }

    public String getEt7() {
        return et7;
    }

    public void setEt7(String et7) {
        this.et7 = et7;
    }

    public String getEt8() {
        return et8;
    }

    public void setEt8(String et8) {
        this.et8 = et8;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Integer> getLabels() {
        return labels;
    }

    public void setLabels(List<Integer> labels) {
        this.labels = labels;
    }

    public static class PriceABean {
        /**
         * value : 88.68
         * uom : PCS
         * unitDes : 包
         * discount : false
         * override : false
         * type : BasePrice
         */

        private double value; //单价值
        private String uom; //计价方式，可以是GRM、KGM、PCS，分别表示g、kg、计数
        private String unitDes; //计数商品单位，暂不支持此字段
        private boolean discount; //允许打折，不填则默认false
        private boolean override; //允许改价，不填则默认false
        private String type = "BasePrice"; //填写固定的BasePrice

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public String getUnitDes() {
            return unitDes;
        }

        public void setUnitDes(String unitDes) {
            this.unitDes = unitDes;
        }

        public boolean isDiscount() {
            return discount;
        }

        public void setDiscount(boolean discount) {
            this.discount = discount;
        }

        public boolean isOverride() {
            return override;
        }

        public void setOverride(boolean override) {
            this.override = override;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class TareBean {
        /**
         * value : 2
         * uom : KGM
         */

        private int value; //商品皮重值
        private String uom; //商品皮重单位，和上述计价方式相同

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }
    }

    public static class PackedBean {
        /**
         * value : 2014-09-03
         * unit : date
         * printable : true
         */

        private String value; //包装日期
        private String unit;  //包装日期单位
        private boolean printable; //包装日期打印标记

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public boolean isPrintable() {
            return printable;
        }

        public void setPrintable(boolean printable) {
            this.printable = printable;
        }
    }

    public static class BestBeforeBean {
        /**
         * value : 1
         * unit : day
         * printable : true
         */

        private String value; //推荐日期
        private String unit; //推荐日期单位
        private boolean printable; //推荐日期打印标记

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public boolean isPrintable() {
            return printable;
        }

        public void setPrintable(boolean printable) {
            this.printable = printable;
        }
    }

    public static class SellByBean {
        /**
         * value : 2
         * unit : day
         * printable : true
         */

        private String value; //保质日期
        private String unit; //保质日期单位
        private boolean printable; //保质日期打印标记

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public boolean isPrintable() {
            return printable;
        }

        public void setPrintable(boolean printable) {
            this.printable = printable;
        }
    }
}
