package com.derbysoft.tinyweb.view;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public class StratgyView implements View {
    private RendingStratgy rendingStratgy;

    @Override
    public String render(Map<String, List<String>> model) {

        try {
           return rendingStratgy.renderView(model);
        } catch (Exception e) {
            throw new RenderException(e);
        }
    }

    public StratgyView(RendingStratgy rendingStratgy) {
        this.rendingStratgy = rendingStratgy;
    }
}
