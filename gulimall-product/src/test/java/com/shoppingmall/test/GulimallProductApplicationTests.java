package com.shoppingmall.test;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shoppingmall.pms.product.GulimallProductApplication;
import com.shoppingmall.pms.product.entity.AttrAttrgroupRelationEntity;
import com.shoppingmall.pms.product.entity.AttrEntity;
import com.shoppingmall.pms.product.entity.BrandEntity;
import com.shoppingmall.pms.product.service.AttrAttrgroupRelationService;
import com.shoppingmall.pms.product.service.AttrService;
import com.shoppingmall.pms.product.service.BrandService;
import com.shoppingmall.pms.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息即可
 * 3、使用OSSClient 进行相关操作
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GulimallProductApplication.class)
public class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath(){

//        Long[] catelogPath = categoryService.findCatelogPath(225L);
//        log.info("完整路径：{}",Arrays.asList(catelogPath));
    }


    @Test
    public void contextSave() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("华为");
        brandEntity.setName("华为");
        brandService.save(brandEntity);

        AttrEntity attrEntity = new AttrEntity();
        attrEntity.setAttrId(2L);
        attrEntity.setAttrName("华为");
        attrService.save(attrEntity);

        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setId(3L);
        attrAttrgroupRelationEntity.setAttrId(3L);
        attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);

        System.out.println("保存成功....");

    }

    @Test
    public void contextLoads() {
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach((item) -> {
            System.out.println(item);
        });
    }

}
