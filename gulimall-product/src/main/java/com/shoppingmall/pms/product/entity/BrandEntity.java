package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@JsonSerialize(using = JsonLongSerializer.class )
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空白")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo 必须是地址")
	@NotEmpty(message = "logo 不能为空")
	private String logo;
	/**
	 * 介绍
	 */
	@NotBlank(message = "介绍不能为空白")
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@Range(min = 0, max = 1, message = "显示状态必须为0或者1")
	@NotNull(message = "显示状态不能为空")
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "^[a-zA-Z]$", message = "首字母必须为1个字母在a-z或者A-Z之间")
	@NotEmpty(message = "检索首字母不能为空")
	private String firstLetter;
	/**
	 * 排序
	 */
	@Min(value = 0, message = "排序必须为大于0的整数")
	@NotNull(message = "排序不能为空")
	private Integer sort;

}
