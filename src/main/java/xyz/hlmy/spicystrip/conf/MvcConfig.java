//package xyz.hlmy.spicystrip.conf;
//
//import cn.dev33.satoken.context.SaHolder;
//import cn.dev33.satoken.filter.SaServletFilter;
//
//import cn.dev33.satoken.interceptor.SaInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import xyz.hlmy.spicystrip.common.R;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//
///**
// * 配置
// */
//@Slf4j
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//    private final List<String> excludeList = Arrays.asList("/sys/user/login", ".js", ".css", ".svg", ".html", ".png", ".html", ".jpeg", ".gif", ".ico", "/error", "/login");
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册 Sa-Token 拦截器，定义详细认证规则
//        registry.addInterceptor(new SaInterceptor(handler -> {
//            // 指定一条 match 规则
//            SaRouter
//                    .match("/**") //拦截
//                    .notMatch(excludeList)
//                    .notMatch("/favicon.ico")//放行
//                    .check(r -> StpUtil.checkLogin());
//
//        })).addPathPatterns("/**");
//    }
//
//    /**
//     * 注册 [Sa-Token全局过滤器]
//     */
//    @Bean
//    public SaServletFilter getSaServletFilter() {
//        return new SaServletFilter()
//                .setBeforeAuth(r -> {
//                    SaHolder.getResponse()
//                            // 服务器名称
//                            .setServer("sa-server")
//                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
//                            .setHeader("X-Frame-Options", "SAMEORIGIN")
//                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
//                            .setHeader("X-XSS-Protection", "1; mode=block")
//                            // 禁用浏览器内容嗅探
//                            .setHeader("X-Content-Type-Options", "nosniff");
//                })
//                .setError(e -> {
//                    return R.err(e.getMessage());
//                })
//                ;
//    }
//
//
//}
