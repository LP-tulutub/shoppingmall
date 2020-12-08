package com.shoppingmall.wms.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.to.SkuHasStockVo;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.wms.ware.entity.WareSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils whereQueryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);
}

