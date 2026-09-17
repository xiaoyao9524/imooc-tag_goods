package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.mapper.TagMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagMarkService {
    @Autowired
    private TagMarkMapper tagMarkMapper;

    public Integer insert (TagMarkEntity tagMarkEntity) {
        return tagMarkMapper.insert(tagMarkEntity);
    }

    public List<TagMarkEntity> queryTagMarkByGoods(Long goodsId) {
        return tagMarkMapper.queryTagMarkByGoods(goodsId);
    }

    public Integer deleteByGoodsId (Long goodsId) {
        return tagMarkMapper.deleteByGoodsId(goodsId);
    }

    public Integer deleteByTagId (Long tagId) {
        return tagMarkMapper.deleteByTagId(tagId);
    }
}
