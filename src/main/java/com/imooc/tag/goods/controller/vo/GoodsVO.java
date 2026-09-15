package com.imooc.tag.goods.controller.vo;

import com.imooc.tag.goods.entity.GoodsEntity;
import lombok.Data;

@Data
public class GoodsVO extends BaseVO {
    private Long id;
    private String name;
    private Double price;
    private String img;
    private String description;

    public static GoodsVO entityToVO (GoodsEntity goodsEntity) {
        GoodsVO goodsVO = new GoodsVO();

        goodsVO.setId(goodsEntity.getId());
        goodsVO.setName(goodsEntity.getName());
        goodsVO.setPrice(goodsEntity.getPrice());
        goodsVO.setImg(goodsEntity.getImg());
        goodsVO.setDescription(goodsEntity.getDescription());

        return goodsVO;
    }
}
