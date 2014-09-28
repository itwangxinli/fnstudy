package com.derbysoft.fn.tinweb.view

import com.derbysoft.tinyweb.view.RenderException

/**
 * Created by xinliwang on 14-9-28.
 */
trait View {
  def render(map: Map[String, List[String]]): String
}

class FunctionView(viewRender: (Map[String, List[String]]) => String) extends View {
  override def render(map: Map[String, List[String]]): String =
    try{
      viewRender(map)
    }catch {
      case e: Exception => throw new RenderException(e)
    }

}