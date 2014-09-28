package com.derbysoft.tinyweb.web;

import com.derbysoft.tinyweb.base.HttpRequest;
import com.derbysoft.tinyweb.filter.Filter;

/**
 * Created by xinliwang on 14-9-28.
 */
public class GreetingFilter implements Filter {

    @Override
    public HttpRequest doFilter(HttpRequest request) {
        System.out.println("In Logging Filter ,request for path" + request.getPath());
        return request;
    }
}
