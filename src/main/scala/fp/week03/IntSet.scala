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

class Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

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
    val treeSet1 = new NonEmpty(3, new Empty, new Empty) incl 2
    val treeSet2 = new NonEmpty(4, new Empty, new Empty) incl 5 incl 6
    println(treeSet1)
    println(treeSet2)
    val t3 = treeSet1 union treeSet2
    println(t3.value)
    println(t3)
  }
}

