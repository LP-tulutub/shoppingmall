package com.shoppingmall.sms.coupon.dao;

import com.shoppingmall.sms.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:14:24
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
