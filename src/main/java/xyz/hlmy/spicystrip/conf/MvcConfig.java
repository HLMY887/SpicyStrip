package xyz.hlmy.spicystrip.conf;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.hlmy.spicystrip.common.R;


/**
 * 配置
 */
//@Slf4j
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//    /**
//     * 注册 [Sa-Token全局过滤器]
//     */
//    @Bean
//    public SaServletFilter getSaServletFilter() {
//        return new SaServletFilter()
//                // 指定 拦截路由 与 放行路由
//                .addInclude("/**").addExclude("/favicon.ico", "/login.html","/sys/user/login")
//                // 前置函数：在每次认证函数之前执行
//                .setBeforeAuth(r -> {
//                    // ---------- 设置一些安全响应头 ----------
//                    SaHolder.getResponse()
//                            // 服务器名称
//                            .setServer("SpicyStrip")
//                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
//                            .setHeader("X-Frame-Options", "SAMEORIGIN")
//                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
//                            .setHeader("X-XSS-Protection", "1; mode=block")
//                            // 禁用浏览器内容嗅探
//                            .setHeader("X-Content-Type-Options", "nosniff");
//                });
//    }
//
//}
