package com.hdtech.dianligongdan.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListHelper {
    public static <T, R> R to(T t, Class<R> tClass) throws ReflectiveOperationException {
        Class<?> sClass = t.getClass();
        //Class rClass = Class.forName("R");
        Constructor<R> rConstructor = tClass.getDeclaredConstructor();
        R r = rConstructor.newInstance();

        Field[] tfields = tClass.getDeclaredFields();
        List<String> tfieldNames = Arrays.stream(tfields).map(Field::getName).collect(Collectors.toList());
        Field[] sfields = sClass.getDeclaredFields();
        for (Field targetField : sfields){
            String fieldName = targetField.getName();
            if(tfieldNames.contains(fieldName)){
                Field s = sClass.getDeclaredField(fieldName);
                if (s != null) {
                    s.setAccessible(true);
                    Object o = s.get(t);
                    targetField.setAccessible(true);
                    targetField.set(r, o);
                }
            }
        }

        return r;
    }

    public static <T, R> List<R> toArray(List<T> source, Class<R> rClass) {
        List<R> list = new ArrayList<>();
        if (source != null) {
            try {
                for (T t : source) {
                    R r = ListHelper.to(t, rClass);
                    list.add(r);
                }
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
