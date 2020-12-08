package com.shoppingmall.sms.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.to.SkuReductionTo;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.sms.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:14:24
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}

