package xyz.hlmy.spicystrip.common;



/**
 * 统一响应值
 */
public class R {

    private Integer code;
    private String msg;
    private Object data;
    private Long total;

    public R() {
    }

    private R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private R(int code, String msg, Object data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }


    public static R page(Object data, long total) {
        return new R(Constant.OK_CODE, Constant.OK_MSG, data, total);
    }

    public static R ok() {
        return new R(Constant.OK_CODE, Constant.OK_MSG, null);
    }

    public static R ok(Object data) {
        return new R(Constant.OK_CODE, Constant.OK_MSG, data);
    }

    public static R ok(String msg, Object data) {
        return new R(Constant.OK_CODE, msg, data);
    }

    public static R err(String msg) {
        return new R(Constant.FAIL_CODE, msg, null);
    }

    public static R err(int errorCode, String msg) {
        return new R(errorCode, msg, null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Long getTotal() {
        return total;
    }

    public R setTotal(Long total) {
        this.total = total;
        return this;
    }

}
