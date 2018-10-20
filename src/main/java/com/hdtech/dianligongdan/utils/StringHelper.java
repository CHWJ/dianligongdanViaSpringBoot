package com.hdtech.dianligongdan.utils;

public class StringHelper {
    public static boolean hasValue(String s) {
        return s != null && !"".equals(s) && !"".equals(s.trim());
    }
}
