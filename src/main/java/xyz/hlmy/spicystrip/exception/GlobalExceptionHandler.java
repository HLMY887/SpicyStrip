package xyz.hlmy.spicystrip.exception;

import cn.dev33.satoken.exception.NotLoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.hlmy.spicystrip.common.Constant;
import xyz.hlmy.spicystrip.common.R;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理SA_TOKEN 异常
     *
     * @param nle
     * @return
     */
    @ExceptionHandler(NotLoginException.class)
    public R handlerSaTokenException(NotLoginException nle) {
        log.info(nle.toString());
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "请先登录";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "登录时间已过期,请重新登录";
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


    /**
     * 处理POST请求参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R validExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        return R.err(Constant.PARAMETER, fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R validExceptionHandler(HttpMessageNotReadableException e) {
        return R.err(Constant.REQUEST_ERROR_CODE, "请求错误");
    }

    @ExceptionHandler(BusinessException.class)
    public R validExceptionHandler(BusinessException e) {
        return R.err(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public R validExceptionHandler(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        return R.err(Constant.ERROR_CODE, "系统错误");
    }
}
