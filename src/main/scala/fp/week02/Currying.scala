package fp.week02

import scala.annotation.tailrec

/**
  * Created by toan on 5/18/16.
  */
object Currying extends App {

  // Linear-recursion version
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  def sumInts(a: Int, b: Int) = sum(i => i, a, b)

  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

  // Tail-recursion version
  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }

  def sum11(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + (sum11(f))(a, b);
  }


  println(sum(a => a, 1, 3))
  println(sum1(a => a)(1, 3))

  // Currying
  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }
  def sumInts1 = sum2(a => a)
  println(sumInts1(1, 3))
  println((sum2(a => a * 2))(1, 3)) // f(x) * g(x) = f(g(x)
}

