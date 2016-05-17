package fp.week01

/**
  * Created by toan on 5/17/16.
  */
object SquareRoot {
  def main(args: Array[String]) {
    println("Welcome to the Scala worksheet")
    def abs(x: Double) = if (x < 0) -x else x
    def sqrt(x: Double) = {
      def sqrtIterate(guess: Double): Double = if (isGoodEnough(guess)) guess else (sqrtIterate(improve(guess)))
      def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) / x < 0.001
      def improve(guess: Double): Double = (guess + x / guess) / 2
      sqrtIterate(1)
    }
    val s2 = sqrt(2)
    val s3 = sqrt(1e60)
    println(s2)
    println(s3)
  }
}
