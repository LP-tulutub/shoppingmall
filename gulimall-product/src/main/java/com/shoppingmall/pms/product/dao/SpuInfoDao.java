package com.shoppingmall.pms.product.dao;

import com.shoppingmall.pms.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * spu信息
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    @Update(value = "UPDATE pms_spu_info SET publish_status = #{code} ,update_time = NOW() WHERE id = #{spuId}")
    void updaSpuStatus(Long spuId, int code);
}
