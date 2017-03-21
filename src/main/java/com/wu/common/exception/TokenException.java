package com.wu.common.exception;


import com.wu.common.exception.base.CommonException;
import com.wu.common.exception.base.CommonExceptionEnum;

/**
 * Created by zhengganglee on 16/9/21.
 */
public class TokenException extends CommonException {

    public TokenException() {
        super(CommonExceptionEnum.US00010);
    }

}
