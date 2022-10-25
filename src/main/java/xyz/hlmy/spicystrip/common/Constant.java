package xyz.hlmy.spicystrip.common;

/**
 * 常数类
 */
public class Constant {
    public final static int OK_CODE = 200;
    public final static int REQUEST_ERROR_CODE = 555;
    public final static int PARAMETER = 444;
    public final static int FAIL_CODE = 400;

    public final static int OTHER_FAIL_CODE = 333;    // 其它错误
    public final static int ERROR_CODE = 9060;
    public final static String OK_MSG = "ok";


    public static final Integer STATE_LEAVE_UNCOMMIT = 0;//未提交
    public static final Integer STATE_LEAVE_INAPPROVAL = 1;//审批中

    public static final Integer STATE_LEAVE_APPROVALED = 2;//审批完成

    public static final Integer STATE_LEAVE_GIVEUP = 3;//已放弃


    public static final String FLAG_OK = "1"; //同意

    public static final String FLAG_PS = "0"; //拒绝


    public static final String SYS = "admin";
}
