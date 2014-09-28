package com.derbysoft.tinyweb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinliwang on 14-9-28.
 */
public class HttpRequest {
private String path;
    private String body;
    private Map<String ,String> headers;

    public HttpRequest(Builder builder) {
        builder.build();
    }

    public String getPath() {
        return path;
    }



    public String getBody() {
        return body;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }



   static  class Builder{
       private String path;
       private String body;
       private Map<String ,String > headers=new HashMap<>();
       public  Builder path(String path){
           this.path=path;
           return this;
       }
       public Builder body(String body){
           this.body=body;
           return this;
       }
       public Builder addHeader(String header,String value) {
           this.headers.put(header, value);
           return this;
       }
       public static Builder builderFrom(HttpRequest request){
           Builder builder = new Builder();
           builder.body(request.getBody());
           builder.path(request.getPath());
           for (String header : request.getHeaders().keySet()) {
               builder.addHeader(header, request.getHeaders().get(header));
           }
           return builder;
       }
       public HttpRequest build() {

           HttpRequest httpRequest = new HttpRequest(this);

           return httpRequest;
       }
   }
}
