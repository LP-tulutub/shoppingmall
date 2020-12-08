package com.shoppingmall.pms.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongArrSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttrRespVo extends AttrVo implements Serializable {

    /**
     * 所属分类
     */
    private String catelogName;

    /**
     * 所属分组
     */
    private String groupName;

    @JsonSerialize(using = JsonLongArrSerializer.class)
    private Long[] catelogPath;

}
