package com.derbysoft.tinyweb.controller;

import com.derbysoft.tinyweb.base.HttpRequest;
import com.derbysoft.tinyweb.base.HttpResponse;

/**
 * Created by xinliwang on 14-9-28.
 */
public interface Controller {
    public HttpResponse handleRequest(HttpRequest request);
}
