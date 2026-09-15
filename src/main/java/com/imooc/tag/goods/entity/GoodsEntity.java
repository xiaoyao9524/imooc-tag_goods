package com.imooc.tag.goods.entity;

import lombok.Data;

@Data
public class GoodsEntity extends BaseEntity {
    private Long id;
    private String name;
    private Double price;
    private String img;
    private String description;
//    private TagEntity[] tagList;
}
