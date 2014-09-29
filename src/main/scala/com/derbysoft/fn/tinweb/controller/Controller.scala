package com.derbysoft.fn.tinweb.controller

import com.derbysoft.fn.tinweb.base.{HttpRequest, HttpResponse}
import com.derbysoft.fn.tinweb.view.View
import com.derbysoft.tinyweb.controller.ControllerException
import com.derbysoft.tinyweb.view.RenderException

/**
 * Created by xinliwang on 14-9-28.
 */
trait Controller {
  def handleRequest(request: HttpRequest): HttpResponse
}

class FunctionController(view: View, doRequest: (HttpRequest)
  => Map[String, List[String]])
  extends Controller {
  override def handleRequest(request: HttpRequest): HttpResponse = {
    try {
      val model: Map[String, List[String]] = doRequest(request)
      HttpResponse(view.render(model), 200);
    } catch {
      case e: RenderException =>
        HttpResponse("Exception while rending", 500);
      case e: ControllerException =>
        HttpResponse("Error while create controller", 500)
      case e: Exception =>
        HttpResponse("", 500)
    }

  }


}
