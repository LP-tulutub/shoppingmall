package com.shoppingmall.pms.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.pms.product.entity.AttrEntity;
import com.shoppingmall.pms.product.vo.AttrGroupRelationVo;
import com.shoppingmall.pms.product.vo.AttrRespVo;
import com.shoppingmall.pms.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils baseQueryPage(Map<String, Object> params, Long catelogId, String type);

    Integer relationUpdateById(AttrVo attrVo);

    AttrRespVo relationGetById(Long attrId);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);

    List<Long> selectSearchAttrs(List<Long> attrIds);
}

