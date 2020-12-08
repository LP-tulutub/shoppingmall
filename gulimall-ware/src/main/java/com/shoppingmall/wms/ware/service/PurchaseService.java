package com.shoppingmall.wms.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.wms.ware.entity.PurchaseEntity;
import com.shoppingmall.wms.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:59:07
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceive(Map<String, Object> params);

    void mergePurchase(Map<String, Object> params);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}

