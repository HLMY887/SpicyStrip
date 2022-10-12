package xyz.hlmy.spicystrip.util;

import java.util.List;

public class StrUtil {

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean isSizeEmpty(List<?> list) {
        return (list.size() == 0);
    }

}
