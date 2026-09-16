package com.imooc.tag.goods.controller.vo;

import com.imooc.tag.goods.entity.GoodsEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GoodsVO extends BaseVO {
    private Long id;
    private String name;
    private Double price;
    private String img;
    private String description;
    private List<TagVO> tagList;

    public static GoodsVO entityToVO (GoodsEntity goodsEntity) {
        GoodsVO goodsVO = new GoodsVO();

        goodsVO.setId(goodsEntity.getId());
        goodsVO.setName(goodsEntity.getName());
        goodsVO.setPrice(goodsEntity.getPrice());
        goodsVO.setImg(goodsEntity.getImg());
        goodsVO.setDescription(goodsEntity.getDescription());

        if (!CollectionUtils.isEmpty(goodsEntity.getTagEntityList())) {
            goodsVO.setTagList(goodsEntity.getTagEntityList().stream().map(TagVO :: transferEntityToVO).collect(Collectors.toList()));
        }

        goodsVO.setCreator(goodsEntity.getCreator());
        goodsVO.setCreateTime(goodsEntity.getCreateTime());
        goodsVO.setModifier(goodsEntity.getModifier());
        goodsVO.setModifyTime(goodsEntity.getModifyTime());

        return goodsVO;
    }
}
