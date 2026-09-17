package com.imooc.tag.goods.common.schedule;

import com.imooc.tag.goods.common.enums.TagStatusEnum;
import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.service.TagMarkService;
import com.imooc.tag.goods.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class TagExpireSchedule {
    @Autowired
    private TagService tagService;

    @Autowired
    private TagMarkService tagMarkService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule() {
        log.info("TagExpireSchedule|schedule start");
        // 1.获取到过期的标签
        List<TagEntity> tagEntitys = tagService.queryExpireTag(new Date());
        // 2.判断标签的过期是否删除标记的状态 == 0
        if (!CollectionUtils.isEmpty(tagEntitys)) {
            tagEntitys.forEach(tagEneity -> {
                tagEneity.setStatus(TagStatusEnum.EXPIRE.getCode());
                tagService.update(tagEneity);
                if (tagEneity.getCleanOnExpire() == 0) {
                    tagMarkService.deleteByTagId(tagEneity.getId());
                }
            });
        }
        // 3.如果==0，那么我们就根据标签删除商品身上的标记

    }
}
