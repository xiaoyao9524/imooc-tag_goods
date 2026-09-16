package com.imooc.tag.goods.controller.param;

import lombok.Data;

import java.util.List;

@Data
public class TagGoodsParam extends BaseParam {
    private Long goodsId;
    private List<Long> tagIdList;
}
