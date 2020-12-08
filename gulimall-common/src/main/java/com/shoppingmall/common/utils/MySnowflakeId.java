package com.shoppingmall.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class MySnowflakeId {
    public static Snowflake snowflakeProduct = IdUtil.getSnowflake(12, 10);
    public static Snowflake snowflakeCoupon = IdUtil.getSnowflake(13, 10);
    public static Snowflake snowflakeMember = IdUtil.getSnowflake(14, 10);
    public static Snowflake snowflakeWare = IdUtil.getSnowflake(16, 10);

}
