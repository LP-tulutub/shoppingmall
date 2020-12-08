package com.shoppingmall.pms.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import com.shoppingmall.pms.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

@Data
public class AttrGroupWithAttrsVo {

    /**
     * 分组id
     */
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long catelogId;

    private List<AttrEntity> attrs;
}
