/**
  * Copyright 2019 bejson.com 
  */
package com.shoppingmall.pms.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * Auto-generated: 2019-11-26 10:50:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Attr {

    @JsonSerialize(using = JsonLongSerializer.class)
    private Long attrId;
    private String attrName;
    private String attrValue;

}