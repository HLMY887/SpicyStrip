package xyz.hlmy.spicystrip.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取操作系统
 */
public class OsTypeUtil {


    public static String getOSType(HttpServletRequest request) {
        String agent = request.getHeader("user-agent");
        if (agent.contains("iPhone") || agent.contains("iPod") || agent.contains("iPad")) {
            return "ios";
        } else if (agent.contains("Android") || agent.contains("Linux")) {
            return "apk";
        } else if (agent.indexOf("micromessenger") > 0) {
            return "wx";
        } else {
            return "pc";
        }
    }
}
