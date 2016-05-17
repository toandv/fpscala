package fp.week02

import scala.annotation.tailrec

/**
  * Created by toan on 5/18/16.
  */
object Sum extends App {
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  def sumInts(a: Int, b: Int) = sum(i => i, a, b)

  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a)  + acc)
    }
    loop(a, 0)
  }

  println(sum(a => a, 1, 3))
  println(sum1(a => a)(1, 3))

}

