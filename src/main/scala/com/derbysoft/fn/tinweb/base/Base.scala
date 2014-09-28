package com.derbysoft.fn.tinweb.base

/**
 * Created by xinliwang on 14-9-28.
 */
case class HttpRequest(path:String,body:String,headers:Map[String,String])
case class HttpResponse(body:String,statusCode:Int)
