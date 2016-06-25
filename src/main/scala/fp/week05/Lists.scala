package fp.week05

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.math.Ordering.StringOrdering

/**
  * Created by toan on 6/23/16.
  */
object Lists {
  @tailrec
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("Empty list.")
    case List(x) => x
    case y :: ys => last(ys)
  }

  // TODO: turn all to tail call
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("Empty list.")
    case List(x) => List()
    case y :: ys => y :: init(ys) // n
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys) // |xs| = n
  }

  // TODO: optimize
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y) // n (n + 1) / 2 => n^2
  }

  def removeAt[T](n: Int, xs: List[T]): List[T] = n match {
    case 0 => xs tail
    case n => List(xs head) ++ removeAt(n - 1, xs tail) // n^2
  }

  def removeAt1[T](n: Int, xs: List[T]) = (xs take n) ++ (xs drop n + 1) // 3n

  @tailrec
  def fac(n: Int, acc: Int): Int = n match {
    case 0 => acc
    case 1 => acc
    case _ => fac(n - 1, acc * n)
  }

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = {
        // 1 3 5
        // 7 8 9
        var result = ListBuffer[Int]()
        var i = 0
        var j = 0
        // n or m
        while (i < xs.length && j < ys.length) {
          if (xs(i) < ys(j)) {
            result += xs(i)
            i = i + 1
          } else {
            result += ys(j)
            j = j + 1
          }
        }

        // n
        while (i < xs.length) {
          result += xs(i)
          i = i + 1
        }

        // m
        while (j < ys.length) {
          result += ys(j)
          j = j + 1
        }
        result.toList
      }

      def mergemp(xs: List[Int], ys: List[Int]): List[Int] = {
        xs match {
          case Nil => ys
          case x :: xs1 =>
            ys match {
              case Nil => xs
              case y :: ys1 =>
                if (x < y) x :: mergemp(xs1, ys)
                else y :: mergemp(xs, ys1)
            }
        }
      }

      def mergemp1(xs: List[Int], ys: List[Int]): List[Int] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) => // n or m
            if (x < y) x :: mergemp1(xs1, ys) // n
            else y :: mergemp1(xs, ys1) // m
        }
      }
      val (fst, snd) = xs splitAt n
      //merge(msort(fst), msort(snd))
      mergemp1(msort(fst), msort(snd))
    }
  }

  def msort1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) => // n or m
            if (ord.lt(x, y)) x :: merge(xs1, ys) // n
            else y :: merge(xs, ys1) // m
        }
      }
      val (fst, snd) = xs splitAt n
      merge(msort1(fst), msort1(snd))
    }
  }

  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3)
    println(last(list))
    println(init(list))
    val con = concat(list, List(10))
    println(con)
    println(removeAt(1, list))
    println(removeAt1(1, list))
    println(msort(List(2, 4, 5, 1, 2)))
    println(msort1(List(2, 4, 5, 1, 2)))
    implicit object strOrd  extends StringOrdering
    println(msort1(List("a", "x", "b", "c")))
  }
}
