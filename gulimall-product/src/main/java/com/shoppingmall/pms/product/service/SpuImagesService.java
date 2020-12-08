package com.shoppingmall.pms.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.utils.PageUtils;
import com.shoppingmall.pms.product.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 13:41:28
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveImages(Long id, List<String> images);
}

