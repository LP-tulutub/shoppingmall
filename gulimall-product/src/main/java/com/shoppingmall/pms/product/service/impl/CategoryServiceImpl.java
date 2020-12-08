package com.shoppingmall.pms.product.service.impl;

import com.shoppingmall.pms.product.entity.CategoryBrandRelationEntity;
import com.shoppingmall.pms.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.Query;

import com.shoppingmall.pms.product.dao.CategoryDao;
import com.shoppingmall.pms.product.entity.CategoryEntity;
import com.shoppingmall.pms.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = this.categoryDao.selectList(new QueryWrapper<>());
        categoryEntities.sort((entity1,entity2) -> { return (int) (entity1.getCatId() - entity2.getCatId());});

        List<CategoryEntity> level1 = categoryEntities.stream()
                .filter((categoryEntity) -> { return categoryEntity.getParentCid() == 0; })
                .map((menu)->{
                    menu.setChildren(getChildren(menu, categoryEntities));
                    return menu;
                })
                .sorted((menu1, menu2) -> {return (menu1.getSort()==null ? 0:menu1.getSort()) - (menu2.getSort()==null ? 0:menu2.getSort());})
                .collect(Collectors.toList());


        return level1;
    }

    @Override
    @Transactional
    public Integer updateArrById(List<CategoryEntity> asList) {
        int value = 0;
        for (CategoryEntity entity : asList){
            value += this.categoryDao.updateById(entity);
        }
        return value;
    }

    @Override
    public Long[] getCatelogIdPath(Long catelogId) {
        CategoryEntity categoryEntity = this.categoryDao.selectById(catelogId);
        List<Long> list = new ArrayList<>();
        list.add(catelogId);
        Long pCid = categoryEntity.getParentCid();
        while (pCid != 0){
            list.add(pCid);
            categoryEntity = this.categoryDao.selectById(pCid);
            pCid = categoryEntity.getParentCid();
        }
        Collections.reverse(list);
        return list.toArray(new Long[list.size()]);
    }

    @Transactional
    @Override
    public Integer redundancyUpdateById(CategoryEntity category) {
        int value = this.categoryDao.updateById(category);
        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("catelog_id", category.getCatId());
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setCatelogName(category.getName());
        boolean update = this.categoryBrandRelationService.update(relationEntity, wrapper);
        if (update) value++;
        return value;
    }

    private List<CategoryEntity> getChildren(CategoryEntity categoryEntity, List<CategoryEntity> list){
        List<CategoryEntity> collect = list.stream()
                .filter(entity -> entity.getParentCid() == categoryEntity.getCatId())
                .map(menu -> {
                    menu.setChildren(getChildren(menu, list));
                    return menu;
                })
                .sorted((menu1, menu2) -> {return (menu1.getSort()==null ? 0:menu1.getSort()) - (menu2.getSort()==null ? 0:menu2.getSort());})
                .collect(Collectors.toList());
        return collect;
    }


}