package com.derbysoft.tinyweb.view;

import java.util.List;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public interface RendingStratgy {
 public String renderView(Map<String ,List<String >> model);
}
