package com.imooc.tag.goods.controller;

import com.imooc.tag.goods.controller.vo.BaseResponse;
import com.imooc.tag.goods.controller.vo.TagVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class TagControllerTest {
    @Autowired
    private TagController tagController;

    @Test
    public void testQueryTagList () {
        Long tagId = null;
        BaseResponse<List<TagVO>> listBaseResponse = tagController.queryTagList(tagId, null);
        Assert.isTrue(listBaseResponse.getCode().equals(0), "testQueryTagList: code不为0！");
    }
}
