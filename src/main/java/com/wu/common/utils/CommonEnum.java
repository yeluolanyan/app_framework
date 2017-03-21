package com.wu.common.utils;

/**
 * Created by wu on 2016/9/12.
 */
public enum CommonEnum {
    //redis前缀值设置
    REDIS_USERID("QLC","userId设置"),
    REDIS_IFBUY("ifBuyPro","是否购买过标的"),
    REDIS_PWD_ERROR_NUM("pwdErrorNum","登录密码错误"),
    REDIS_PAY_PWD_NUM("payPwdErrorNum","支付密码错误"),
    REDIS_GESTURE_PWD_NUM("gesturePwdErrorNum","手势密码错误"),

    //短信验证码类型
    SMS_CODE_REGISTER("REGISTER","注册"),
    SMS_CODE_PAY("PAY","支付"),
    SMS_CODE_PASSWORD("FORGOT","找回密码"),
    SMS_CODE_UPDATEPASSWORD("UPDATEPASSWORD","修改密码成功"),
    SMS_CODE_WEB_LOGIN("WEB_LOGIN","后台登录短信验证"),

    //用户是否可用状态
    USER_AVAILABLE_Y("Y","可用"),
    USER_AVAILABLE_N("N","不可用"),
    //用户认证注册状态
    USER_STATUS_RE("REGISTER","注册"),
    USER_STATUS_AUTH("AUTH","实名认证"),
    USER_STATUS_BANK("BANK","绑定银行卡"),

    IS_DEFAULT_Y("Y","是默认"),
    IS_DEFAULT_N("N","不是默认"),

    IS_DELETE_Y("Y","删除"),
    IS_DELETE_N("N","未删除"),


    IF_BUY_PRO_Y("Y","已经购买过标"),
    IF_BUY_PRO_N("N","未买过标"),

    USER_TYPE_GENERAL("GENERAL","普通用户"),
    USER_TYPE_SPECIAL("SPECIAL","特约用户"),
    USER_TYPE_GOOD("GOOD","优质用户")
    ;



    private String code;
    private String msg;

    CommonEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
