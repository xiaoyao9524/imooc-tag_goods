package com.imooc.tag.goods.controller.vo;

import com.imooc.tag.goods.entity.TagEntity;
import lombok.Data;

@Data
public class TagVO extends BaseVO {
    private Long id;
    private String name;
    private String description;
    private Integer status;
    private String style;
    private Integer cleanOnDelete;
    private Integer cleanOnExpire;

    public static TagVO transferEntityToVO(TagEntity tagEntity) {
        TagVO tagVO = new TagVO();

        tagVO.setId(tagEntity.getId());
        tagVO.setName(tagEntity.getName());
        tagVO.setStyle(tagEntity.getStyle());
        tagVO.setDescription(tagEntity.getDescription());
        tagVO.setStatus(tagEntity.getStatus());
        tagVO.setCreator(tagEntity.getCreator());
        tagVO.setModifier(tagEntity.getModifier());
        tagVO.setCreateTime(tagEntity.getCreateTime());
        tagVO.setModifyTime(tagEntity.getModifyTime());

        return tagVO;
    }
}
