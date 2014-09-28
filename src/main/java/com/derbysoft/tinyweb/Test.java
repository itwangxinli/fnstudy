package com.derbysoft.tinyweb;

/**
 * Created by xinliwang on 14-9-27.
 */
public class Test {
    public static void main(String[] args) {
        HttpResponse.Builder.newBuilder().body("a").responseCode(2).build();
    }
}
