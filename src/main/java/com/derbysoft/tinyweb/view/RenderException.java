package com.derbysoft.tinyweb.view;

/**
 * Created by xinliwang on 14-9-28.
 */
public class RenderException extends RuntimeException {
    public RenderException() {
        super();
    }

    public RenderException(Exception e) {
        super("rendering view exception",e);
    }
}
