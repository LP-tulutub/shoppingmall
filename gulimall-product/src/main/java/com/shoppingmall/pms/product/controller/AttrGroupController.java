package com.shoppingmall.pms.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shoppingmall.common.utils.MySnowflakeId;
import com.shoppingmall.pms.product.entity.AttrEntity;
import com.shoppingmall.pms.product.service.AttrAttrgroupRelationService;
import com.shoppingmall.pms.product.service.AttrService;
import com.shoppingmall.pms.product.service.CategoryService;
import com.shoppingmall.pms.product.vo.AttrGroupRelationVo;
import com.shoppingmall.pms.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.pms.product.entity.AttrGroupEntity;
import com.shoppingmall.pms.product.service.AttrGroupService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;

import javax.management.relation.RelationService;


/**
 * 属性分组
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttrService attrService;
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @GetMapping("/{catelogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable("catelogId")Long catelogId){

        //1、查出当前分类下的所有属性分组，
        //2、查出每个属性分组的所有属性
        List<AttrGroupWithAttrsVo> vos =  attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
        return R.ok().put("data",vos);
    }

    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> vos){

        attrAttrgroupRelationService.saveBatch(vos);
        return R.ok();
    }

    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> entities =  attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data",entities);
    }

    @GetMapping("/{attrgroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                            @RequestParam Map<String, Object> params){
        PageUtils page = attrService.getNoRelationAttr(params, attrgroupId);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list/{catelogId}")
    public R listByCatId(@RequestParam Map<String, Object> params,@PathVariable Long catelogId){
        PageUtils page = attrGroupService.queryPageByCatelogId(params, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        return R.ok().put("attrGroup", attrGroup);
    }

    @RequestMapping("/infos/{attrGroupId}")
    public R infos(@PathVariable("attrGroupId") Long attrGroupId){
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long[] arrLong = this.categoryService.getCatelogIdPath(attrGroup.getCatelogId());

        attrGroup.setCatelogIdPath(arrLong);
        return R.ok().put("attrGroup", attrGroup);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
        if (attrGroup.getAttrGroupId() == null)
            attrGroup.setAttrGroupId(MySnowflakeId.snowflakeProduct.nextId());
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody  AttrGroupRelationVo[] vos){
        attrService.deleteRelation(vos);
        return R.ok();
    }
}
