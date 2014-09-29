package com.derbysoft.fn.tinweb

import com.derbysoft.fn.tinweb.base.{HttpResponse, HttpRequest}
import com.derbysoft.fn.tinweb.controller.FunctionController
import com.derbysoft.fn.tinweb.view.FunctionView

import scala.util.Random

/**
 * Created by xinliwang on 14-9-28.
 */
object Test {
  def main(args: Array[String]) {
    val web: TinyWeb = new TinyWeb(controllers=
      Map("greetings" -> greetingController),
      filters=List(loggingFilter)
    )
    var request: Option[HttpResponse] = web.handleRequest(testRequest)
    println(request)
  }

  def greetingViewRender(model: Map[String, List[String]]) = {
    "<h1>Friendly Greeting View:%s</h1>".format(
      model getOrElse("greetings", List[String]())
        map (rendingGreeting)
        mkString (",")

    )
  }

  def handGreetingRequest(request: HttpRequest) = Map("greetings" -> request.body.split(",").toList.map(makeString))


  def random = new Random()

  def greetings = Vector("Hello", "Holda", "Hi", "Greetings")

  def makeString(name: String) = "%s-%s".format(greetings(random.nextInt(3)), name)


  def rendingGreeting(greeting: String) = "<h2>%s<h2>".format(greeting)

  def greetingView = new FunctionView(greetingViewRender)

  def greetingController = new FunctionController(greetingView, handGreetingRequest)

  def loggingFilter(request: HttpRequest) = {
    println("In Logging Filter ,request for path:" + request.path)
    request
  }

def testRequest=HttpRequest("greetings","wang,liu,guo",Map("xa"->"ta"))
}
