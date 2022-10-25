package xyz.hlmy.spicystrip.util;

import cn.dev33.satoken.stp.StpUtil;

import xyz.hlmy.spicystrip.model.sys.entity.SysUser;

/**
 * 获取用户工具类
 */
public class RequestUtils {

    private static final String SESSION_USER_KEY = "login-user";

    public static void putLoginUser(SysUser user) {
        StpUtil.getSession(true).set(SESSION_USER_KEY, user);
    }

    public static SysUser getLoginUser() {
        return (SysUser) StpUtil.getSession().get(SESSION_USER_KEY);
    }

}
