package com.shoppingmall.sms.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.hutool.core.bean.BeanUtil;
import com.shoppingmall.common.to.SpuBoundTo;
import com.shoppingmall.common.utils.MySnowflakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.sms.coupon.entity.SpuBoundsEntity;
import com.shoppingmall.sms.coupon.service.SpuBoundsService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;



/**
 * 商品spu积分设置
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:14:24
 */
@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {
    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:spubounds:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuBoundsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:spubounds:info")
    public R info(@PathVariable("id") Long id){
		SpuBoundsEntity spuBounds = spuBoundsService.getById(id);

        return R.ok().put("spuBounds", spuBounds);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:spubounds:save")
    public R save(@RequestBody SpuBoundsEntity spuBounds){
		spuBoundsService.save(spuBounds);

        return R.ok();
    }

    @PostMapping("/many/save")
    public R manySave(@RequestBody SpuBoundTo spuBoundTo){
        SpuBoundsEntity spuBounds = new SpuBoundsEntity();
        BeanUtil.copyProperties(spuBoundTo, spuBounds);
        spuBounds.setId(MySnowflakeId.snowflakeCoupon.nextId());
        spuBoundsService.save(spuBounds);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:spubounds:update")
    public R update(@RequestBody SpuBoundsEntity spuBounds){
		spuBoundsService.updateById(spuBounds);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:spubounds:delete")
    public R delete(@RequestBody Long[] ids){
		spuBoundsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
