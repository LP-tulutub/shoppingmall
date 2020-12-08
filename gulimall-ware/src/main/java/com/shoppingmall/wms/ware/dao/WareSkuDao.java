package com.shoppingmall.wms.ware.dao;

import com.shoppingmall.wms.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 商品库存
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    void addStock(Long skuId, Long wareId, Integer skuNum);

    @Select(value = "SELECT SUM(stock - stock_locked) FROM wms_ware_sku WHERE sku_id = #{skuId}")
    Long getSkuStock(Long item);
}
