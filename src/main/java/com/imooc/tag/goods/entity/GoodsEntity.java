package com.imooc.tag.goods.entity;

import lombok.Data;

import java.util.List;

@Data
public class GoodsEntity extends BaseEntity {
    private Long id;
    private String name;
    private Double price;
    private String img;
    private String description;
    private List<TagEntity> tagEntityList;
}
