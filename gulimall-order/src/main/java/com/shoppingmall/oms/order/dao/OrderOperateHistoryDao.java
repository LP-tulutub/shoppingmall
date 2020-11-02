package com.shoppingmall.oms.order.dao;

import com.shoppingmall.oms.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:48:53
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
