package xyz.hlmy.spicystrip.exception;


import xyz.hlmy.spicystrip.common.Constant;


public class BusinessException extends RuntimeException {

    public Constant errorCode;

    public String errorMessage;

    public BusinessException(Constant errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(Constant errorCode) {
        this.errorCode = errorCode;
//        this.errorMessage = Constant.MESSAGE.get(errorCode.getCode());
    }

    public String getErrorCode() {
        return errorCode.toString();
    }
}
