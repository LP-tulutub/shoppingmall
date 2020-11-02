package com.shoppingmall.sms.coupon.dao;

import com.shoppingmall.sms.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:14:24
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
