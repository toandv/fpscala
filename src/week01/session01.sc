package week01

object session01 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  1 + 2                                           //> res0: Int(3) = 3
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double = if (isGoodEnough(guess)) guess else (sqrtIter(improve(guess)))

    def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double = (guess + x / guess) / 2

    sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res1: Double = 1.4142156862745097

  sqrt(1e60)                                      //> res2: Double = 1.0000788456669446E30
}