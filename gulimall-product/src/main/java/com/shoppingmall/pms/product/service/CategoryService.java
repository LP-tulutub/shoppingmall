package com.shoppingmall.pms.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.pms.product.entity.AttrGroupEntity;
import com.shoppingmall.pms.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    Integer updateArrById(List<CategoryEntity> asList);

    Long[] getCatelogIdPath(Long catelogId);

    Integer redundancyUpdateById(CategoryEntity category);
}

