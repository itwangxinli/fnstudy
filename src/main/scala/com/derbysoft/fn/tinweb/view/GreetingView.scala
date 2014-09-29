package com.derbysoft.fn.tinweb.view

/**
 * Created by xinliwang on 14-9-29.
 */
class GreetingView {

  def greetingViewRender(model:Map[String,List[String]])={
    "<h1>Friendly Greeting View:%s</h1>".format(
    model getOrElse("greetings",List[String]())
      map(rendingGreeting)
      mkString( ",")

    )
  }

  def rendingGreeting(greeting:String)="<h2>%s<h2>".format(greeting)

}
