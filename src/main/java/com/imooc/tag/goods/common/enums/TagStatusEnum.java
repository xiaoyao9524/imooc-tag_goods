package com.imooc.tag.goods.common.enums;

public enum TagStatusEnum {
    USE(1, "使用中"),
    DELETE(2, "已删除"),
    EXPIRE(3, "已过期");

    private Integer code;
    private String name;

    TagStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
