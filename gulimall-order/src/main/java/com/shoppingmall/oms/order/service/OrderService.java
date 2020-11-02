package com.shoppingmall.oms.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.oms.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:48:53
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

