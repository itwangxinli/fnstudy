package com.derbysoft.tinyweb;

/**
 * Created by xinliwang on 14-9-27.
 */
public class HttpResponse {

    private final String body;

    private final Integer responseCode;

    public String getBody() {
        return body;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public HttpResponse(Builder builder) {
        this.body = builder.body;
        this.responseCode = builder.responseCode;
    }

    public static class Builder {
        private String body;
        private Integer responseCode;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder responseCode(Integer responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public HttpResponse build() {


            return new HttpResponse(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

    }

    public static void main(String[] args) {

        HttpResponse response = Builder.newBuilder().body("abc").responseCode(200).build();
    }
}
