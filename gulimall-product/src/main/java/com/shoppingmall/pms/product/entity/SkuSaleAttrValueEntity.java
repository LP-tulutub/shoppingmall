package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * sku销售属性&值
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long skuId;
	/**
	 * attr_id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long attrId;
	/**
	 * 销售属性名
	 */
	private String attrName;
	/**
	 * 销售属性值
	 */
	private String attrValue;
	/**
	 * 顺序
	 */
	private Integer attrSort;

}
