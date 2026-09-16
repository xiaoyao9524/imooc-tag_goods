package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.entity.GoodsEntity;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.entity.TagMarkEntity;
import com.imooc.tag.goods.service.GoodsService;
import com.imooc.tag.goods.service.TagMarkService;
import com.imooc.tag.goods.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {
    @Autowired
    private TagService tagService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TagMarkService tagMarkService;

    @RequestMapping("/test")
    public String test (Model model) {
        model.addAttribute("name", "二十七");
        return "test/test";
    }


    @RequestMapping("/")
    public String main () {
        return "main/main";
    }

    @RequestMapping("/tag/tagList")
    public String tagList () {
        return "tag/tagList";
    }

    @RequestMapping("/tag/tagAdd")
    public String tagAdd () {
        return "tag/tagAdd";
    }

    @RequestMapping("/tag/tagUpdate/{id}")
    public String tagUpdate (@PathVariable Long id, Model model) {
        TagEntity tagEntity = tagService.queryTagById(id);
        model.addAttribute("tag", tagEntity);
        return "tag/tagUpdate";
    }

    @RequestMapping("/goods/goodsList")
    public String goodsList () {
        return "goods/goodsList";
    }

    @RequestMapping("/goods/goodsAdd")
    public String goodsAdd () {
        return "goods/goodsAdd";
    }

    @RequestMapping("/goods/goodsTag/{id}")
    public String goodsTag (@PathVariable Long id, Model model) {
        model.addAttribute("goodsId", id);
        List<TagMarkEntity> tagMarkEntity = tagMarkService.queryTagMarkByGoods(id);
        List<Long> tagIdList = tagMarkEntity.stream().map(TagMarkEntity::getTagId).collect(Collectors.toList());
        model.addAttribute("tagIdList", tagIdList);
        return "goods/goodsTag";
    }

    @RequestMapping("/goods/goodsDetail")
    public String goodsDetail (Model model) {
        List<GoodsEntity> goodEneitys = goodsService.queryGoodsList(null, "");
        model.addAttribute("goodsDetail", goodEneitys);

        return "goods/goodsDetail";

    }

}
