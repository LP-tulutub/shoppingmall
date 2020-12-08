package com.shoppingmall.wms.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * 
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
@Data
@TableName("wms_purchase_detail")
public class PurchaseDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	@TableId
	private Long id;
	/**
	 * 采购单id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long purchaseId;
	/**
	 * 采购商品id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long skuId;
	/**
	 * 采购数量
	 */
	private Integer skuNum;
	/**
	 * 采购金额
	 */
	private BigDecimal skuPrice;
	/**
	 * 仓库id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long wareId;
	/**
	 * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
	 */
	private Integer status;

}
