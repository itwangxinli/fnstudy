package com.derbysoft.tinyweb.controller;

/**
 * Created by xinliwang on 14-9-28.
 */
public class ControllerException extends RuntimeException{
    private Integer causeCode;
    public ControllerException(Integer causeCode,String msg) {
        super(msg);
        this.causeCode=causeCode;
    }

    public ControllerException(Throwable cause,Integer causeCode) {
        super(cause);
        this.causeCode=causeCode;
    }

    public Integer getCauseCode() {
        return causeCode;
    }
}
