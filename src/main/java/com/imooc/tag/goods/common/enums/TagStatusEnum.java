package com.imooc.tag.goods.common.enums;

public enum TagStatusEnum {
    USE(0, "使用中"),
    DELETE(1, "已删除"),
    EXPIRE(2, "已过期");

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
