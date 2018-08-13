package com.hdtech.dianligongdan.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    public <T, R> List<R> toArray(List<T> t, Class<R> rClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, rClass);
            String json = toJson(t);

            List<R> list = mapper.readValue(json, javaType);
            return list;
        } catch (IOException e) {
            return null;
        }
    }

    public <T> String toJson(List<T> t) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}