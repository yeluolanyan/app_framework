package com.wu.common.exception.base;

/**
 * Created by zhengganglee on 16/9/21.
 */
public class CommonException extends Exception {

    private String outcome;

    private String message;

    public CommonException(CommonExceptionEnum exception) {
        super(exception.getMessage());
        this.outcome = exception.getOutcome();
        this.message = exception.getMessage();
    }

    public CommonException(CommonExceptionEnum exception, String message) {
        super(exception.getMessage());
        this.outcome = exception.getOutcome();
        this.message = message;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable fillInStackTrace() {
//        return super.fillInStackTrace();
        return  null ;
    }
}
