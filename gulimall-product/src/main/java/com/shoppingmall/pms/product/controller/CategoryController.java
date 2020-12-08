package com.shoppingmall.pms.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.naming.pojo.AbstractHealthChecker;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.shoppingmall.common.utils.MySnowflakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.pms.product.entity.CategoryEntity;
import com.shoppingmall.pms.product.service.CategoryService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;



/**
 * 商品三级分类
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list/tree")
    public R listTree(){
        List<CategoryEntity> categoryEntities = this.categoryService.listWithTree();
        R r = new R();
        r.put("data", categoryEntities);
        return r;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
        if (category.getCatId() == null)
            category.setCatId(MySnowflakeId.snowflakeProduct.nextId());
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    @PostMapping("/redundancy/update")
    public R redundancyUpdate(@RequestBody CategoryEntity category){
        categoryService.redundancyUpdateById(category);
        return R.ok();
    }


    /**
     * 修改数组量
     */
    @RequestMapping("/update/arr")
    public R updateArrByIds(@RequestBody CategoryEntity[] categoryArr){
        Integer value = categoryService.updateArrById(Arrays.asList(categoryArr));
        if (value != categoryArr.length) return R.error();
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
