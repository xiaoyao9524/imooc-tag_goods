package com.imooc.tag.goods.mapper;

import com.imooc.tag.goods.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<GoodsEntity> queryGoodsList(@Param("id") Long id, @Param("name") String name);
    Integer insertGoods(GoodsEntity goodsEntity);
}
