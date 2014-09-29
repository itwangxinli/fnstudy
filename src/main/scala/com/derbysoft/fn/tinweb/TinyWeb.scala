package com.derbysoft.fn.tinweb

import com.derbysoft.fn.tinweb.base.{HttpRequest, HttpResponse}
import com.derbysoft.fn.tinweb.controller.Controller

/**
 * Created by xinliwang on 14-9-29.
 */
class TinyWeb(filters: List[(HttpRequest) => HttpRequest],
              controllers: Map[String, Controller]) {
  def handleRequest(request: HttpRequest): Option[HttpResponse] = {
   val composedFilter= filters.reverse.reduceLeft((composed, next) =>
     composed compose next)
    val filterRequest:HttpRequest=composedFilter(request)
    val controller = controllers.get(filterRequest.path);
    controller map (controller => controller.handleRequest(filterRequest))

  }


}
