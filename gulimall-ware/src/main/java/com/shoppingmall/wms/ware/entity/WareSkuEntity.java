package com.shoppingmall.wms.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * 商品库存
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
@Data
@TableName("wms_ware_sku")
public class WareSkuEntity implements Serializable {
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
	 * 仓库id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long wareId;
	/**
	 * 库存数
	 */
	private Integer stock;
	/**
	 * sku_name
	 */
	private String skuName;
	/**
	 * 锁定库存
	 */
	private Integer stockLocked;

}
