package com.shoppingmall.pms.product.service.impl;

import com.shoppingmall.pms.product.entity.CategoryBrandRelationEntity;
import com.shoppingmall.pms.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.Query;

import com.shoppingmall.pms.product.dao.BrandDao;
import com.shoppingmall.pms.product.entity.BrandEntity;
import com.shoppingmall.pms.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public Integer redundancyUpdateById(BrandEntity brand) {
        int value = this.brandDao.updateById(brand);
        QueryWrapper<CategoryBrandRelationEntity> wrapper =
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brand.getBrandId());
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setBrandName(brand.getName());
        boolean update = this.categoryBrandRelationService.update(relationEntity, wrapper);
        if (update) value++;
        return value;
    }

}