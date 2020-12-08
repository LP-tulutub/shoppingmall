package com.shoppingmall.common.to;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpuBoundTo {
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
