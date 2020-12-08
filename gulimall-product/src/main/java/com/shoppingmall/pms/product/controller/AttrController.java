package com.shoppingmall.pms.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.hutool.core.bean.BeanUtil;
import com.shoppingmall.common.utils.MySnowflakeId;
import com.shoppingmall.pms.product.entity.AttrAttrgroupRelationEntity;
import com.shoppingmall.pms.product.entity.ProductAttrValueEntity;
import com.shoppingmall.pms.product.service.AttrAttrgroupRelationService;
import com.shoppingmall.pms.product.service.ProductAttrValueService;
import com.shoppingmall.pms.product.vo.AttrRespVo;
import com.shoppingmall.pms.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.pms.product.entity.AttrEntity;
import com.shoppingmall.pms.product.service.AttrService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;


/**
 * 商品属性
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     *  获取spu规格
     */
    @GetMapping("/base/listforspu/{spuId}")
    public R baseAttrlistforspu(@PathVariable("spuId") Long spuId){

        List<ProductAttrValueEntity> entities = productAttrValueService.baseAttrListforspu(spuId);

        return R.ok().put("data",entities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseList(@RequestParam Map<String, Object> params, @PathVariable Long catelogId, @PathVariable("attrType") String type){
        PageUtils page = attrService.baseQueryPage(params, catelogId, type);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
        AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    @GetMapping("/relation/info/{attrId}")
    public R relationInfo(@PathVariable("attrId") Long attrId){
		AttrRespVo attrRespVo = attrService.relationGetById(attrId);

        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrEntity attr){
        if (attr.getAttrId() == null)
            attr.setAttrId(MySnowflakeId.snowflakeProduct.nextId());
		attrService.save(attr);

        return R.ok();
    }

    @Transactional
    @PostMapping("/relation/save")
    public R relationSave(@RequestBody AttrVo attrVO){
        AttrEntity attrEntity = new AttrEntity();
        BeanUtil.copyProperties(attrVO, attrEntity, "attrGroupId");

        Long attrSnowflakeId = MySnowflakeId.snowflakeProduct.nextId();
        attrEntity.setAttrId(attrSnowflakeId);

        this.attrService.save(attrEntity);
        if (attrVO.getAttrType() == 1){
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setId(MySnowflakeId.snowflakeProduct.nextId());
            relationEntity.setAttrId(attrSnowflakeId);
            relationEntity.setAttrGroupId(attrVO.getAttrGroupId());

            this.attrAttrgroupRelationService.save(relationEntity);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    @PostMapping("/relation/update")
    public R relationUpdate(@RequestBody AttrVo attrVo){
        attrService.relationUpdateById(attrVo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
