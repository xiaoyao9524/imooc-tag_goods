package com.imooc.tag.goods.service;

import com.imooc.tag.goods.common.constant.CommonConstant;
import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private TagMarkService tagMarkService;

    @Autowired
    private TagService tagService;


    public List<GoodsEntity> queryGoodsList(Long id, String name) {
        List<GoodsEntity> goodsEntities = goodsMapper.queryGoodsList(id, name);
        if (CollectionUtils.isEmpty(goodsEntities)) {
            return new ArrayList<>();
        }

        goodsEntities.forEach(goodsEneity -> {
            List<TagMarkEntity> tagMarkEntities = tagMarkService.queryTagMarkByGoods(goodsEneity.getId());
            if (!CollectionUtils.isEmpty(tagMarkEntities)) {
                List<Long> tagIdList = tagMarkEntities.stream().map(TagMarkEntity::getTagId).collect(Collectors.toList());

                List<TagEntity> tagEntitys = tagService.queryTagByIds(tagIdList);
                goodsEneity.setTagEntityList(tagEntitys);
            }
        });
        return goodsEntities;
    }

    public Integer insertGoods(GoodsEntity goodsEntity) {
        Integer result = goodsMapper.insertGoods(goodsEntity);
        insertTagMark(goodsEntity);

        return result;
    }

    private void insertTagMark(GoodsEntity goodsEntity) {
        TagMarkEntity tagMarkEntity = new TagMarkEntity();

        tagMarkEntity.setGoodsId(goodsEntity.getId());
        tagMarkEntity.setTagId(CommonConstant.NEW_SHOP_TAG_ID);
        tagMarkEntity.setCreator(goodsEntity.getCreator());
        tagMarkEntity.setModifier(goodsEntity.getModifier());
        tagMarkEntity.setCreateTime(goodsEntity.getCreateTime());
        tagMarkEntity.setModifyTime(goodsEntity.getModifyTime());

        tagMarkService.insert(tagMarkEntity);
    }
}
