package xyz.hlmy.spicystrip.exception;

import cn.dev33.satoken.exception.NotLoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.hlmy.spicystrip.common.R;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotLoginException.class)
    public R handlerSaTokenException(NotLoginException nle) {
        log.info(nle.toString());
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "请先登录";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "登录时间已过期,请重新登录";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "您已被顶下线";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "您已被踢下线";
        } else {
            message = "当前会话未登录";
        }
        return R.err(400, message);
    }
}
