package fp.week01

import scala.annotation.tailrec

object TailRec extends App {
  def factorial(n: Long): Long = if (n == 0) 1 else n * factorial(n - 1)

  def tailrecFactorial(n: Long): Long = {
    @tailrec
    def loop(acc: Long, n: Long): Long =
      if (n <= 0) acc
      else loop(n * acc, n - 1)

    def loop1(acc: Long, n: Long): Long = {
      var acc1 = acc
      var n1 = n

      while (n1 > 0) {
        acc1 = acc1 * n1
        n1 = n1 - 1
      }
      acc1
    }
    loop1(1, n)
  }

  println(factorial(25))
  println(tailrecFactorial(25))

}