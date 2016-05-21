package fp.week01

import scala.annotation.tailrec

/**
  * Created by toan on 5/17/16.
  */
object SquareRoot extends  App {
    def abs(x: Double) = if (x < 0) -x else x

    def sqrt(x: Double) = {

      @tailrec
      def sqrtIterate(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIterate(improve(guess))

      def isGoodEnough(guess: Double): Boolean =
        abs(guess * guess - x) / x < 0.001

      def improve(guess: Double): Double =
        (guess + x / guess) / 2

      sqrtIterate(1)
    }

    val s1 = sqrt(2)
    val s2 = sqrt(1e60)
    println(s1)
    println(s2)

    def sqrt1(x: Double) = {
      def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) / x < 0.001
      def improve(guess: Double): Double =
        (guess + x / guess) / 2
      var guess: Double = 1
      while (!isGoodEnough(guess)) {
        guess = improve(guess)
      }
      guess
    }

    val s3 = sqrt1(2)
    val s4 = sqrt1(1e60)
    println(s3)
    println(s4)
}
