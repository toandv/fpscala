package fp.week03

/**
  * Created by toan on 6/5/16.
  */
abstract class IntSet {
  def contains(x: Int): Boolean

  def incl(x: Int): IntSet

  def union(other: IntSet): IntSet

  def value: Int = 0
}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def toString = "."

  override def union(other: IntSet) = other

}

class NonEmpty(elem: Int, left: IntSet, right: IntSet)
  extends IntSet {
  override def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  override def union(other: IntSet) = {
    val rl = left union right
    val u = rl union other
    u incl elem
  }

  override def toString = " {" + left + elem + right + "} "

  override def value = elem;
}


object IntSet {
  def main(args: Array[String]) {
    val treeSet1 = new NonEmpty(2, Empty, Empty) incl 1
    val treeSet2 = new NonEmpty(3, Empty, Empty) incl 4
    println(treeSet1)
    println(treeSet2)
    val t3 = treeSet1 union treeSet2
    println(t3.value)
    println(t3)

    //val l: List1[IntSet] = List1(new NonEmpty(1, Empty, Empty))

    val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
    //val b: Array[IntSet] = a

    type A = IntSet => NonEmpty
    type B = NonEmpty => IntSet

    def apply(f: A): Unit =  {

    }
    //val b: B = x => x

    //apply(x: IntSet => x)

  }

}

