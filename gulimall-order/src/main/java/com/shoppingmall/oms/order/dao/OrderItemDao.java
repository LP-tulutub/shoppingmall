package com.shoppingmall.oms.order.dao;

import com.shoppingmall.oms.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:48:53
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
