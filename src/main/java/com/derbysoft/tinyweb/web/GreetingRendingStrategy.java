package com.derbysoft.tinyweb.web;

import com.derbysoft.tinyweb.view.RendingStratgy;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public class GreetingRendingStrategy implements RendingStratgy {
    @Override
    public String renderView(Map<String, List<String>> model) {
        List<String> greetings = model.get("greetings");
        StringBuffer buffer = new StringBuffer();
        buffer.append("<h1>friendly greetings</h1>\n");
        for (String greeting : greetings) {
            buffer.append(String.format("<h2>%s</h2>\n",greeting));
        }
        return buffer.toString();
    }
}
