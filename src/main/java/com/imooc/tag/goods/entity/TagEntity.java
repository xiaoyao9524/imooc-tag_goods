package com.imooc.tag.goods.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TagEntity extends BaseEntity {
    private Long id;
    private String name;
    private String style;
    private String description;
    private Integer status;
    private Date expireTime;
    private Integer cleanOnDelete;
    private Integer cleanOnExpire;
}
