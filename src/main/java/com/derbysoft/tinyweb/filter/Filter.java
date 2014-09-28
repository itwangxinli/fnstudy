package com.derbysoft.tinyweb.filter;

import com.derbysoft.tinyweb.base.HttpRequest;

/**
 * Created by xinliwang on 14-9-28.
 */
public interface Filter {
    public HttpRequest doFilter(HttpRequest request);
}
