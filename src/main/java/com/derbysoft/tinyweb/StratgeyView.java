package com.derbysoft.tinyweb;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public class StratgeyView implements View {
    private RendingStratgy rendingStratgy;

    @Override
    public String render(Map<String, List<String>> model) {

        try {
            rendingStratgy.renderView(model);
        } catch (Exception e) {
            throw new RenderException(e);
        }

        return null;
    }

    public StratgeyView(RendingStratgy rendingStratgy) {
        this.rendingStratgy = rendingStratgy;
    }
}
