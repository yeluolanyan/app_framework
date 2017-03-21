package com.wu.common.utils;

/**
 * Created by lwh on 2016/9/22.
 */
public class UserHolder {
    private static ThreadLocal<Integer> userIdHolder = new ThreadLocal<Integer>();
    public static Integer getUserId(){
        return userIdHolder.get();
    }
    public static void setUserId(Integer userId){
        userIdHolder.set(userId);
    }
    public static void removeUserId(){
        userIdHolder.remove();
    }
}
