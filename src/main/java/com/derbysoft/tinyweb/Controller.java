package com.derbysoft.tinyweb;

/**
 * Created by xinliwang on 14-9-28.
 */
public interface Controller {
    public HttpResponse handleRequest(HttpRequest request);
}
