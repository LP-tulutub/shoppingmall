package com.shoppingmall.common.to;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

@Data
public class SkuHasStockVo {

    @JsonSerialize(using = JsonLongSerializer.class)
    private Long skuId;

    private Boolean hasStock;

}
