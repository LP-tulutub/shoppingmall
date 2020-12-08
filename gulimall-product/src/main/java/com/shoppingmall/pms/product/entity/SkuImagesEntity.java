package com.shoppingmall.pms.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shoppingmall.common.config.JsonLongSerializer;
import lombok.Data;

/**
 * sku图片
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
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
	 * 图片地址
	 */
	private String imgUrl;
	/**
	 * 排序
	 */
	private Integer imgSort;
	/**
	 * 默认图[0 - 不是默认图，1 - 是默认图]
	 */
	private Integer defaultImg;

}
