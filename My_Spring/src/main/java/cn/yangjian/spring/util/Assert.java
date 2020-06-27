package cn.yangjian.spring.util;

import java.util.Collection;

public class Assert {

    public static boolean isNotEmpty(Collection<?> c) {
        return c != null && c.size() > 0;
    }

    public static String isNull(Object object) {
        return "Object  is  null?" + (object == null);
    }

    public static boolean isEffectiveString(String value) {
        return value != null && !value.equals("");
    }
}
