package fp.week03

/**
  * Created by toan on 6/8/16.
  */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](e: U): List[U] = new Cons[U](e, this)
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, Nil))
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}


object Cons {
  def singleton[T](elem: T) = new Cons[T](elem, Nil)

  def main(args: Array[String]) {
    val s = singleton[Double](1)
    println(s)

    val x: List[String] = Nil
  }
}