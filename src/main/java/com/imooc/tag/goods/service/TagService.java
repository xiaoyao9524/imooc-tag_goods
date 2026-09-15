package com.imooc.tag.goods.service;

import com.imooc.tag.goods.entity.TagEntity;
import com.imooc.tag.goods.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;
    public List<TagEntity> queryTagList (Long id, String tagName) {
        return tagMapper.queryTagList(id, tagName);
    }

    public TagEntity queryTagById (Long id) {
        return tagMapper.queryTagById(id);
    }

    public Integer insert (TagEntity tagEntity) {
        return tagMapper.insert(tagEntity);
    }

    public Integer update (TagEntity tagEntity) {
        return tagMapper.update(tagEntity);
    }
}
