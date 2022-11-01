package xyz.hlmy.spicystrip.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;

import java.util.Date;

public class Util {

    //获取当前用户
    public static SysUser getUser() {
        return (SysUser) StpUtil.getSession(true).get(SaSession.USER);
    }

    //设置KEY
    public static String getKey(String prefix) {
        if (prefix == null) {
            prefix = "";
        }
        return prefix + DateUtil.format(new Date(), "yyyyMMdd") + RandomUtil.randomNumbers(4);
    }
}
