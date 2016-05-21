package fp.week02

import scala.annotation.tailrec

/**
  * Created by toan on 5/21/16.
  */
object Product extends App {

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b);
  }

  def suml(f: Int => Int)(a: Int, b: Int): Int = {
    // @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  val s1 = suml(x => x)(1, 3)
  val s = sum(x => x)(1, 3) // f(1) + sum(2, 3); sum(2, 3) = f(2) + sum(3, 3);
  // sum(3, 3) = f(3) + sum(4, 3); sum(4, 3) = 0
  // (f(1) + (f(2) + (f(3) + 0))); + is the combinator

  def product1(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 1)
  }

  def fact(n: Int) = product(a => a)(1, n)

  val f1_10 = fact(3)
  println(f1_10)
}
