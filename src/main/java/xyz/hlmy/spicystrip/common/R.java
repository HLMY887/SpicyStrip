package xyz.hlmy.spicystrip.common;

public class R<T> {

    private int code;

    private String message;

    private T data;

    private ErrorInfo errorInfo;

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public R(int code, String message, T data, ErrorInfo errorInfo) {
        this(code, message, data);
        this.errorInfo = errorInfo;
    }

    public static final R<Void> OK = new R<>(200, "ok", null, null);

    public static <S> R<S> ok(S data) {
        return new R<>(200, "ok", data, null);
    }

    public static <S> R<S> error(int statusCode, String message) {
        return new R(statusCode, message);
    }

    public static <S> R<S> err(int statusCode, String message) {
        return new R<>(statusCode, message, null, null);
    }

    public static <S> R<S> err(int statusCode, String message, ErrorInfo errorInfo) {
        return new R<>(statusCode, message, null, errorInfo);
    }

    public static <S> R<S> err(int statusCode, String message, int errCode, String errMessage) {
        return new R<>(statusCode, message, null, new ErrorInfo(errCode, errMessage));
    }

    public static <S> R<S> err(int statusCode, String message, int errCode, String errMessage, Object errData) {
        return new R<>(statusCode, message, null, new ErrorInfo(errCode, errMessage));
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
