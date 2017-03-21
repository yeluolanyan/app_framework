package com.wu.common.response;


import java.io.Serializable;

/**
 * Created by wu on 2016/9/13.
 */
public class BaseResponse<T> implements Serializable{
    private int code = ResponseEnum.SUCCESS.getCode() ;
    private String msg = ResponseEnum.SUCCESS.getMsg() ;
    private T res  ;

    public BaseResponse(){};

    public BaseResponse (int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse (int code,String msg,T res){
        this.code = code;
        this.msg = msg;
        this.res = res;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
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
