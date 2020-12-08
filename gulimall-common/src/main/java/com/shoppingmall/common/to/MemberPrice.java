/**
  * Copyright 2019 bejson.com 
  */
package com.shoppingmall.common.to;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Auto-generated: 2019-11-26 10:50:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class MemberPrice {

    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;
    private String name;
    private BigDecimal price;

}