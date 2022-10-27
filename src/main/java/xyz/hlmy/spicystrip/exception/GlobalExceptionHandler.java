package xyz.hlmy.spicystrip.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.hlmy.spicystrip.common.R;

import java.util.Objects;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public R handlerException(Exception e) {
        log.error("全局异常捕获，异常消息:" + e.getMessage());
        return R.err("系统异常，请联系管理员~");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("校验参数异常:" + e.getMessage());
        return R.err(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(NotLoginException.class)
    public R handlerNotLoginException(NotLoginException e) {
        log.error("登录失效异常:" + e.getMessage());
        return R.err(400, "未登录");
    }

    @ExceptionHandler(NotPermissionException.class)
    public R handlerNotPermissionException(NotPermissionException e) {
        log.error("权限不足异常:" + e.getMessage());
        return R.err(400, "无权访问");
    }

    @ExceptionHandler(BusinessException.class)
    public R handlerBusinessException(BusinessException e) {
        log.error("业务逻辑异常: " + e.getMessage());
        return R.err(400, e.getMessage());
    }

    @ExceptionHandler(NotRoleException.class)
    public R handlerNotRoleException(NotRoleException e) {
        log.error("角色未知异常: " + e.getMessage());
        return R.err(400, "无权访问");
    }


}
