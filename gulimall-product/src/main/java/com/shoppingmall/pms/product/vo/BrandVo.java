package com.shoppingmall.pms.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

@Data
public class BrandVo {

    /**
     * "brandId": 0,
     * "brandName": "string",
     */
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long brandId;
    private String  brandName;
}
