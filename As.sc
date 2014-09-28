object Session {
  def abs(x: Double) = if (x > 0) x else -x

  abs(-3)

  def square(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess), x)
    def isGoodEnough(guess: Double) = abs(guess * guess - x) / x < 0.001
    def improve(guess: Double) = (guess + x / guess) / 2
    sqrtIter(1.0, x)
  }

  val result = square(2)
  val abc = square(1e60)
  square(1e-6)
}