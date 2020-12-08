package com.shoppingmall.pms.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.pms.product.entity.BrandEntity;
import com.shoppingmall.pms.product.entity.CategoryBrandRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryBrandRelationEntity> queryByBrandId(Long brandId);

    List<BrandEntity> getBrandsByCatId(Long catId);
}

