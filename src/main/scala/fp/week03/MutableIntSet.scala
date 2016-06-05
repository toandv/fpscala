package fp.week03

/**
  * Created by toan on 6/5/16.
  */
abstract class MutableIntSet {
  def incl(x: Int): Unit

  def contains(x: Int): Boolean

  def elem: Int

  def parent: MutableIntSet

  var left: MutableIntSet

  var right: MutableIntSet

}

class MIntSet(var elem: Int,
              var left: MutableIntSet,
              var right: MutableIntSet,
              var parent: MutableIntSet)
  extends MutableIntSet {

  override def incl(x: Int): Unit = {
    var parent: MutableIntSet = this;
    var node: MutableIntSet = this;

    while (node != null) {
      parent = node
      if (x < this.elem) node = node.left
      else if (x > this.elem) node = node.right
      else return
    }

    if (x < parent.elem) parent.left = new MIntSet(x, null, null, parent)
    else parent.right = new MIntSet(x, null, null, parent)

  }

  override def contains(x: Int): Boolean = ???

  override def toString = "{" + toString(left) + "-" + elem + "-" + toString(right) + "}"

  def toString(value: Any): String = if (value == null) "{}" else value.toString
}

object MutableIntSet {
  def main(args: Array[String]) {
    val set = new MIntSet(1, null, null, null)
    set incl 2
    set incl 3
    set incl 1
    set incl 0
    println(set)
  }
}



