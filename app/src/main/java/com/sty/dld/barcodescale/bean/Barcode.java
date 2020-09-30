package com.sty.dld.barcodescale.bean;

/**
 * 条码
 * @Author: tian
 * @UpdateDate: 2020/9/23 9:31 AM
 */
public class Barcode {
    /**
     * id : 1
     * type : EAN13
     * description : 1
     * definition : 24PPPPPBBBBBC
     */
    /**
     * {
     *     "id": "21",
     *     "type": "QRCode",
     *     "description": "adv barcode",
     *     "definition": "$R(Registration -Separator 13[$D(ItemDescription -l 10)$D(TransactionNetWeight -l 5)$D(TransactionUnitPrice -l 5)$D(TransactionTotalPrice -l 5)])"
     * }
     */
    private String id; //条码号
    private String type; //条码类型
    private String description; //条码描述
    private String definition; //条码格式定义

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
