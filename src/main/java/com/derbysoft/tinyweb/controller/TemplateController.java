package com.derbysoft.tinyweb.controller;

import com.derbysoft.tinyweb.base.HttpRequest;
import com.derbysoft.tinyweb.base.HttpResponse;
import com.derbysoft.tinyweb.view.RenderException;
import com.derbysoft.tinyweb.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public abstract class TemplateController implements Controller {
    private View view;

    public TemplateController(View view) {
        this.view = view;
    }

    @Override
    public HttpResponse handleRequest(HttpRequest request) {
        Integer responseCode = 200;
        String responseBody = "";
        try {
            Map<String, List<String>> model = doRequest(request);
            responseBody = view.render(model);
        } catch (ControllerException ce) {
            responseCode = ce.getCauseCode();
        } catch (RenderException re) {
            responseBody = "Exception While rending";
            responseCode = 500;
        } catch (Exception e) {
            responseCode = 500;
        }
        return HttpResponse.Builder.newBuilder()
                .body(responseBody).
                        responseCode(responseCode).build();
    }

    protected abstract Map<String, List<String>> doRequest(HttpRequest request);
}
