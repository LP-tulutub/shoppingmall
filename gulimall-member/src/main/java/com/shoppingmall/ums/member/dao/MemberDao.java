package com.shoppingmall.ums.member.dao;

import com.shoppingmall.ums.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lp
 * @email 347863282@qq.cpm
 * @date 2020-11-02 14:31:59
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
