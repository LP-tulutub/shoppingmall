package com.shoppingmall.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class JsonLongArrSerializer extends JsonSerializer<Long[]> {

    @Override
    public void serialize(Long[] longs, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String[] strings = new String[longs.length];
        for (int i = 0; i < longs.length; i++) strings[i] = longs[i].toString();
        jsonGenerator.writeObject(strings);
    }
}
