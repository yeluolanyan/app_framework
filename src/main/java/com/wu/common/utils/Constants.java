package com.wu.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wu on 2016/9/12.
 */
public class Constants {
    //短信有效时长30*60秒
    public static final int SMS_VALID_TIME = 5 * 60;
    //userToken有效期 秒
    public static final int TOKEN_TIME = 7 * 24 * 60 * 60 ;

    //登录密码错误次数限制
    public static final int ERROR_PWD_NUM = 5;
    //支付密码错误次数限制
    public static final int ERROR_PAY_PWD_NUM = 5;
    //登录密码错误次数限制
    public static final int ERROR_GESTURE_PWD_NUM = 5;
    //密码错误有效时长
    public static final int ERROR_PWD_TIME = 24 * 60 * 60 ;


}
