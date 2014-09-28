package com.derbysoft.tinyweb;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public class TinyWeb {
    private final Map<String, Controller> controllers;
    private final List<Filter> filters;

    public TinyWeb(Map<String,Controller> controllers,List<Filter> filters){
        this.controllers=controllers;
        this.filters=filters;
    }

    public HttpResponse handleRequest(HttpRequest httpRequest) {
        HttpRequest currentRequest=httpRequest;
        for (Filter filter : filters) {
            currentRequest=filter.doFilter(httpRequest);
        }
        Controller controller = controllers.get(currentRequest.getPath());
        if(controller!=null){
            return controller.handleRequest(currentRequest);
        }
        return null;
    }
}
