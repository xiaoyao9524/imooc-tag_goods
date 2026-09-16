package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue;
import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.GoodsVO;
import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public BaseResponse<List<GoodsVO>> queryGoodsList (Long id, String name) {
        BaseResponse baseResponse = BaseResponse.getSuccessResult(BaseResponse.class);
        List<GoodsEntity> goodsEntitys = goodsService.queryGoodsList(id, name);

        List<GoodsVO> goodsVOS = goodsEntitys.stream().map(GoodsVO :: entityToVO).collect(Collectors.toList());

        baseResponse.setData(goodsVOS);

        return baseResponse;
    }

    @PostMapping("/goods")
    @AutoFillDefaultValue
    public BaseResponse<Integer> insertGoods(@RequestBody GoodsEntity goodsEntity) {
        BaseResponse<Integer> baseResponse = BaseResponse.getSuccessResult(BaseResponse.class);
        Integer result = goodsService.insertGoods(goodsEntity);

        baseResponse.setData(result);

        return baseResponse;
    }
}
