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
 * 属性&属性分组关联
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	@TableId
	private Long id;
	/**
	 * 属性id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long attrId;
	/**
	 * 属性分组id
	 */
	@JsonSerialize(using = JsonLongSerializer.class)
	private Long attrGroupId;
	/**
	 * 属性组内排序
	 */
	private Integer attrSort;

}
