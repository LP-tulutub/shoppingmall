package com.shoppingmall.pms.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

@Data
public class AttrGroupRelationVo {

    //"attrId":1,"attrGroupId":2
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long attrId;

    @JsonSerialize(using = JsonLongSerializer.class)
    private Long attrGroupId;
}
