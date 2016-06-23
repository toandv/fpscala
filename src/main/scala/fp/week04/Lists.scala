package fp.week04

/**
  * Created by toan on 6/20/16.
  */
object Lists {
  def main(args: Array[String]) {
    val nums = 2 :: List(5, 3, 1)
    def isort(xs: List[Int]): List[Int] = xs match {
      case List() => List()
      case y :: ys => insert(y, isort(ys))
    }
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x > y) x :: xs else y :: insert(x, ys)
    }
    val sorted = isort(nums)
    println(sorted)
  }

}
