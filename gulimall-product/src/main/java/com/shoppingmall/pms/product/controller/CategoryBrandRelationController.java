package com.shoppingmall.pms.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.shoppingmall.common.utils.MySnowflakeId;
import com.shoppingmall.pms.product.entity.BrandEntity;
import com.shoppingmall.pms.product.service.BrandService;
import com.shoppingmall.pms.product.service.CategoryService;
import com.shoppingmall.pms.product.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.pms.product.entity.CategoryBrandRelationEntity;
import com.shoppingmall.pms.product.service.CategoryBrandRelationService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;

import javax.validation.constraints.NotBlank;


/**
 * 品牌分类关联
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/catelog/list")
    public R catelogList(@RequestParam Map<String, Object> params){
        Long brandId = Long.parseLong((String) params.get("brandId"));
        List<CategoryBrandRelationEntity> entityList = categoryBrandRelationService.queryByBrandId(brandId);

        return R.ok().put("data", entityList);
    }

    @GetMapping("/brands/list")
    public R relationBrandsList(@RequestParam(value = "catId",required = true)Long catId){
        List<BrandEntity> vos = categoryBrandRelationService.getBrandsByCatId(catId);

        List<BrandVo> collect = vos.stream().map(item -> {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(item.getBrandId());
            brandVo.setBrandName(item.getName());

            return brandVo;
        }).collect(Collectors.toList());

        return R.ok().put("data",collect);

    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        if (categoryBrandRelation.getId() == null)
            categoryBrandRelation.setId(MySnowflakeId.snowflakeProduct.nextId());
		categoryBrandRelationService.save(categoryBrandRelation);

        return R.ok();
    }

    @PostMapping("/catelog/save")
    public R catelogSave(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        String brandName = this.brandService.getById(categoryBrandRelation.getBrandId()).getName();
        String categoryName = this.categoryService.getById(categoryBrandRelation.getCatelogId()).getName();
        categoryBrandRelation.setBrandName(brandName);
        categoryBrandRelation.setCatelogName(categoryName);
        this.categoryBrandRelationService.save(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
