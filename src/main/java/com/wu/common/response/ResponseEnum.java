package com.wu.common.response;

/**
 * Created by wu on 2016/9/12.
 */
public enum ResponseEnum {
    SUCCESS(0,"请求成功"),
    FAIL(10001,"请求失败"),
    USER_NAME_ERROR(10002,"用户名不存在"),
    PASSWORD_ERROR(10003,"密码错误"),
    USER_UNAVAILABLE(10004,"账户不可用"),
    SMS_CODE_ERROR(10005,"验证码错误"),
    SMS_SEND_ERROR(10006,"验证码发送失败"),
    IDENTITY_AUTH_ERROR(10007,"实名认证失败"),
    IDCARD_IS_AUTH(10008,"该身份证已经被认证"),
    TOKEN_ERROR(10009,"token验证失败"),
    MOBILE_IS_REG(10010,"手机号已被注册"),
    USERNAME_NO_MATCH(10011,"用户手机号与身份证号不匹配"),

    ;



    private int code;
    private String msg;

    ResponseEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
