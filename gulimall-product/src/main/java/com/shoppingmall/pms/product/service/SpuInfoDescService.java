package com.shoppingmall.pms.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.pms.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);
}

