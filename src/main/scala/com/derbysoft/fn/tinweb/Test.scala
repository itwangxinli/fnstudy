package com.derbysoft.fn.tinweb

import com.derbysoft.fn.tinweb.base.HttpRequest

/**
 * Created by xinliwang on 14-9-28.
 */
class Test {
  def main(args: Array[String]) {
    HttpRequest(path = "/greeting", body = "wang,liu,zhang", headers = Map("x_test" -> "Test"))
  }
}
