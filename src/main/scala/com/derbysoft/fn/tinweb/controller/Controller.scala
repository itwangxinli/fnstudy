package com.derbysoft.fn.tinweb.controller

import com.derbysoft.fn.tinweb.base.{HttpResponse, HttpRequest}
import com.derbysoft.fn.tinweb.view.View

import com.derbysoft.tinyweb.controller.ControllerException
import com.derbysoft.tinyweb.view.RenderException

/**
 * Created by xinliwang on 14-9-28.
 */
trait Controller {
  def handleRequest(request: HttpRequest): HttpResponse
}

class FunctionController(view: View, doRequest: (HttpRequest) => Map[String, List[String]])
  extends Controller {
  override def handleRequest(request: HttpRequest): HttpResponse = {
    var responseCode = 200
    var responseBody = ""
    try {

      val model: Map[String, List[String]] = doRequest(request)
     responseBody= view.render(model)
    } catch {
      case e: RenderException =>
        responseCode = 500
        responseBody = "Exception while rending"
      case e: ControllerException =>
        responseCode = e.getCauseCode
        responseBody = "Error while create controller"
        HttpResponse(responseCode=e.getCauseCode,responseBody="")
      case e:Exception=>
        responseCode=500
        HttpResponse("",500)
    }

  }


}
