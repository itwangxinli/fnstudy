package com.derbysoft.tinyweb;

import com.derbysoft.tinyweb.base.HttpRequest;
import com.derbysoft.tinyweb.base.HttpResponse;
import com.derbysoft.tinyweb.controller.Controller;
import com.derbysoft.tinyweb.filter.Filter;
import com.derbysoft.tinyweb.view.StratgyView;
import com.derbysoft.tinyweb.web.GreetingController;
import com.derbysoft.tinyweb.web.GreetingFilter;
import com.derbysoft.tinyweb.web.GreetingRendingStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xinliwang on 14-9-27.
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Controller> controllerMap = new HashMap<>();
        controllerMap.put("/greeting",new GreetingController(new StratgyView(new GreetingRendingStrategy())));


        List<? extends Filter> filters = Arrays.asList(new GreetingFilter());

        TinyWeb tinyWeb = new TinyWeb(controllerMap, filters);
     HttpResponse response=   tinyWeb.handleRequest(HttpRequest.Builder.newBuilder().


                path("/greeting").body("tim,xinli,zhanjun,guanxi").build());
        System.out.println("response.getResponseCode() = " + response.getResponseCode());
        System.out.println("response.getBody() = " + response.getBody());
    }
}
