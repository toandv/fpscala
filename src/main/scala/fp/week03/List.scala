package fp.week03

import scala.annotation.tailrec

/**
  * Created by toan on 6/8/16.
  */
trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def prepend[U >: T](e: U): List[U] = new Cons[U](e, this)

  def last: T

}

case class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def last: T = {
    @tailrec
    def last(xs: List[T]): T = xs match {
      case Nil => throw new Error("Nil")
      case Cons(head, tail) => if (tail.isEmpty) head else last(tail)
    }
    last(this)
  }
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")

  override def last: Nothing = throw new NoSuchElementException("Nil.last")
}


object Cons {
  def apply[T](x1: T, x2: T): List[T] = Cons[T](x1, new Cons[T](x2, Nil))

  def main(args: Array[String]) {
    val xs = Cons(1, new Cons(2, new Cons(3, Nil)))

    println(xs.last)
  }

}