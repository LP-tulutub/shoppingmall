package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongArrSerializer;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * 属性分组
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分组id
	 */
	@JsonSerialize(using = JsonLongSerializer.class )
	@TableId
	private Long attrGroupId;
	/**
	 * 组名
	 */
	private String attrGroupName;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 描述
	 */
	private String descript;
	/**
	 * 组图标
	 */
	private String icon;
	/**
	 * 所属分类id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long catelogId;

	@JsonSerialize(using = JsonLongArrSerializer.class )
	@TableField(exist = false)
	private Long[] catelogIdPath;
}
