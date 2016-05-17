package fp.week01

object ConditionalExpression {
  def main(args: Array[String]): Unit = {
    val x = if (2 > 0) 2 else 0
    def loop: Boolean = loop
    
    def and(x: Boolean, y: => Boolean) = if (x) y else false
    def  or(x: Boolean, y: Boolean) = if (!x) y else true
    println(and(true, true))
    println(and(true, false))
    
    println(or(true, false))
    println(or(false, true))
    
    // terminates
    println(and(false, loop))
    
    // never terminates
    println(and(true, loop))
  }
}