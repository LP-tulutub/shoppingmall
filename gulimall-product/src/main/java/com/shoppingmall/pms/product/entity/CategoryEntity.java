package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * 商品三级分类
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类id
	 */
	@JsonSerialize(using = JsonLongSerializer.class )
	@TableId
	private Long catId;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 父分类id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long parentCid;
	/**
	 * 层级
	 */
	private Integer catLevel;
	/**
	 * 是否显示[0-不显示，1显示]
	 */
	@TableLogic(value = "1", delval = "0")
	private Integer showStatus;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 图标地址
	 */
	private String icon;
	/**
	 * 计量单位
	 */
	private String productUnit;
	/**
	 * 商品数量
	 */
	private Integer productCount;

	//@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
	@TableField(exist = false)
	private List<CategoryEntity> Children;

}
