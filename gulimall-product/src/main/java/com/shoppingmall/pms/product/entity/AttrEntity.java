package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * 商品属性
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	@TableId
	private Long attrId;
	/**
	 * 属性名
	 */
	private String attrName;
	/**
	 * 是否需要检索[0-不需要，1-需要]
	 */
	private Integer searchType;
	/**
	 * 属性图标
	 */
	private String icon;
	/**
	 * 可选值列表[用逗号分隔]
	 */
	private String valueSelect;
	/**
	 * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
	 */
	private Integer attrType;
	/**
	 * 启用状态[0 - 禁用，1 - 启用]
	 */
	private Long enable;
	/**
	 * 所属分类
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long catelogId;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
	 */
	private Integer showDesc;

}
