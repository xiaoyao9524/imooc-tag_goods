package com.imooc.tag.goods.mapper;

import com.imooc.tag.goods.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    List<TagEntity> queryTagList(@Param("id") Long id, @Param("tagName") String tagName);
    TagEntity queryTagById(@Param("id") Long id);
    List<TagEntity> queryTagByIds(List<Long> tagIdList);
    Integer insert(TagEntity tagEntity);
    Integer update(TagEntity tagEntity);
}
