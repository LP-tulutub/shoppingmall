package com.shoppingmall.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 解决后端输出 Long 型数据过长前端精度丢失的问题
 * 在需要的 entity 类字段上加上 @JsonSerialize(using = JsonLongSerializer.class )
 */
public class JsonLongSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(Long.toString(aLong));
    }
}
