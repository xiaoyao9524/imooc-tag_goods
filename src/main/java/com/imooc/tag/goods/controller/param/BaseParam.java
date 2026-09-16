package com.imooc.tag.goods.controller.param;

import lombok.Data;

import java.util.Date;

@Data
public class BaseParam {
    private Integer creator;
    private Integer modifier;
    private Date createTime;
    private Date modifyTime;
}
