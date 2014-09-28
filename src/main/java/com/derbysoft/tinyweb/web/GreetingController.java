package com.derbysoft.tinyweb.web;

import com.derbysoft.tinyweb.base.HttpRequest;
import com.derbysoft.tinyweb.controller.TemplateController;
import com.derbysoft.tinyweb.view.View;

import java.util.*;

/**
 * Created by xinliwang on 14-9-28.
 */
public class GreetingController extends TemplateController {
    private Random random;

    @Override
    protected Map<String, List<String>> doRequest(HttpRequest request) {
        HashMap<String, List<String>> modelMap = new HashMap<>();
        modelMap.put("greetings", generateGreetings(request.getBody()));
        return modelMap;
    }

    private List<String> generateGreetings(String nameCommaSplited) {
        String[] names = nameCommaSplited.split(",");
        ArrayList<String> greetings = new ArrayList<>();
        for (String name : names) {
            greetings.add(greeting(name));
        }
        return greetings;
    }

    private String greeting(String name) {
        String[] greetings = new String[]{"greeting", "hello", "Salutations", "Hola"};
        String greetingPrefix = greetings[random.nextInt(4)];
        return greetingPrefix + "  " + name;
    }

    public GreetingController(View view) {
        super(view);
        this.random = new Random();
    }
}
