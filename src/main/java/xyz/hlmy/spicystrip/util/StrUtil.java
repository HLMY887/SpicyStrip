package xyz.hlmy.spicystrip.util;

import java.util.List;

/**
 * 空判断
 */
public class StrUtil {

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean isSizeEmpty(List<?> list) {
        return (list.size() == 0);
    }


    public static String jointLike(String value) {
        return "%" + value + "%";
    }
}
