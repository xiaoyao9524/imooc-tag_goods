package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    public List<GoodsEntity> queryGoodsList (Long id, String name) {
       return goodsMapper.queryGoodsList(id, name);
    }

    public Integer insertGoods(GoodsEntity goodsEntity) {
        return goodsMapper.insertGoods(goodsEntity);
    }
}
