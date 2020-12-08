package com.shoppingmall.wms.ware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.shoppingmall.common.utils.MySnowflakeId;
import com.shoppingmall.wms.ware.vo.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shoppingmall.wms.ware.entity.PurchaseEntity;
import com.shoppingmall.wms.ware.service.PurchaseService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.common.utils.R;



/**
 * 采购信息
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 完成采购单
     */
    @PostMapping(value = "/done")
    public R finish(@RequestBody PurchaseDoneVo doneVo) {

        purchaseService.done(doneVo);

        return R.ok();
    }

    /**
     * 领取采购单
     */
    @PostMapping(value = "/received")
    public R received(@RequestBody List<Long> ids) {

        purchaseService.received(ids);

        return R.ok();
    }

    /**
     * 合并整单
     */
    @PostMapping(value = "/merge")
    public R merge(@RequestBody Map<String, Object> params) {
        purchaseService.mergePurchase(params);

        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping(value = "/unreceive/list")
    public R unreceiveList(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceive(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchase:info")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchase:save")
    public R save(@RequestBody PurchaseEntity purchase){
        if (purchase == null) return R.error("存储内容不能为空");
        else purchase.setId(MySnowflakeId.snowflakeWare.nextId());
		purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchase:update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchase:delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
